package ch.lab4tech.jav09.gui;

import ch.lab4tech.jav09.gui.bottom.ResultPanel;
import ch.lab4tech.jav09.gui.middle.RequestPanel;
import ch.lab4tech.jav09.gui.top.FormPanel;
import ch.lab4tech.jav09.model.Category;
import ch.lab4tech.jav09.model.Movie;
import ch.lab4tech.jav09.model.Rating;
import ch.lab4tech.jav09.repository.CategoryRepository;
import ch.lab4tech.jav09.repository.MovieRepository;
import ch.lab4tech.jav09.repository.RatingRepository;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class MainGUI extends JFrame implements ActionListener, ListSelectionListener, ItemListener {

	private final FormPanel formPanel;
	private final RequestPanel requestPanel;
	private final ResultPanel resultPanel;
	private final MovieRepository movieRepository;
	private Object currentActionEventSource = null;

	public MainGUI(
		CategoryRepository categoryRepository,
		RatingRepository ratingRepository,
		MovieRepository movieRepository
	) {
		this.setResizable(false);
		this.setTitle("Liste de films");
		this.setSize(new Dimension(800, 600));
		this.getContentPane().setLayout(new BorderLayout(0, 0));
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		this.movieRepository = movieRepository;

		formPanel = new FormPanel(this, categoryRepository, ratingRepository);
		requestPanel = new RequestPanel();
		resultPanel = new ResultPanel();

		this.getContentPane().add(formPanel, BorderLayout.NORTH);
		this.getContentPane().add(requestPanel, BorderLayout.CENTER);
		this.getContentPane().add(resultPanel, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		currentActionEventSource = actionEvent.getSource();
		boolean isAutoRequery = formPanel.isAuto();

		JRadioButton auto = formPanel.getRightTopPanel().getAuto();
		JRadioButton noAuto = formPanel.getRightTopPanel().getNoAuto();
		JButton request = formPanel.getRightTopPanel().getRequest();
		JButton clear = formPanel.getRightTopPanel().getClear();

		if (currentActionEventSource == auto && request.getBackground() == Color.RED) {
			formPanel.getRightTopPanel().resetRequestButton();
			showResults();
		}

		if (currentActionEventSource == noAuto) {
			request.setBackground(Color.RED);
		}

		if (currentActionEventSource == request && !isAutoRequery) {
			showResults();
		}

		if (currentActionEventSource == clear) {
			formPanel.reset();
			requestPanel.reset();
			resultPanel.reset();
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent listSelectionEvent) {
		JButton clear = formPanel.getRightTopPanel().getClear();
		boolean isAutoRequery = formPanel.isAuto();

		if (isAutoRequery && !listSelectionEvent.getValueIsAdjusting() && currentActionEventSource != clear) {
			showResults();
		}
		currentActionEventSource = null;
	}

	@Override
	public void itemStateChanged(ItemEvent itemEvent) {
		JButton clear = formPanel.getRightTopPanel().getClear();
		boolean isAutoRequery = formPanel.isAuto();

		if (isAutoRequery && currentActionEventSource != clear) {
			showResults();
		}
		currentActionEventSource = null;
	}

	private void showResults() {
		List<Category> currentCategories = formPanel.getCurrentCategories();
		List<Rating> currentRatings = formPanel.getCurrentRatings();

		List<Movie> movies = findMoviesByFilters(currentCategories, currentRatings);

		resultPanel.reset();
		// requestPanel.print();

		if (!movies.isEmpty()) {
			resultPanel.printResults(movies);
		} else {
			resultPanel.showInfo();
		}
	}

	private List<Movie> findMoviesByFilters(List<Category> categories, List<Rating> ratings) {
		// If no filters are selected, return all movies
		if (categories.isEmpty() && ratings.isEmpty()) {
			return movieRepository.findAll();
		}

		// Extract category codes
		List<Integer> categoryCodes = categories.stream().map(Category::getCode).toList();

		// Extract rating codes
		List<String> ratingCodes = ratings.stream().map(Rating::getRatingId).toList();

		// If only categories are selected
		if (!categoryCodes.isEmpty() && ratingCodes.isEmpty()) {
			return movieRepository
				.findAll()
				.stream()
				.filter(movie -> categoryCodes.contains(movie.getCategoryCode()))
				.toList();
		}

		// If only ratings are selected
		if (categoryCodes.isEmpty() && !ratingCodes.isEmpty()) {
			return movieRepository
				.findAll()
				.stream()
				.filter(movie -> ratingCodes.contains(movie.getRating()))
				.toList();
		}

		// If both filters are selected
		return movieRepository.findByCategoriesAndRatings(categoryCodes, ratingCodes);
	}
}
