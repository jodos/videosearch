package ch.lab4tech.jav09.gui;

import ch.lab4tech.jav09.dao.MovieDAO;
import ch.lab4tech.jav09.dao.MovieJdbcDAO;
import ch.lab4tech.jav09.gui.bottom.ResultPanel;
import ch.lab4tech.jav09.gui.middle.RequestPanel;
import ch.lab4tech.jav09.gui.top.FormPanel;
import ch.lab4tech.jav09.model.Category;
import ch.lab4tech.jav09.model.Movie;
import ch.lab4tech.jav09.model.Rating;
import lombok.Getter;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

@Getter
public class MainGUI extends JFrame implements ActionListener, ListSelectionListener, ItemListener {

    private FormPanel formPanel;
    private RequestPanel requestPanel;
    private ResultPanel resultPanel;
    private Object currentActionEventSource = null;

    public MainGUI() {
        this.setResizable(false);
        this.setTitle("Liste de films");
        this.setSize(new Dimension(800, 600));
        this.getContentPane().setLayout(new BorderLayout(0, 0));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        formPanel = new FormPanel(this);
        requestPanel = new RequestPanel(this);
        resultPanel = new ResultPanel(this);

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

        if (currentActionEventSource == auto) {
            if (request.getBackground() == Color.RED) {
                formPanel.getRightTopPanel().resetRequestButton();
                showResults();
            }
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

        MovieDAO movieJdbcDAO = new MovieJdbcDAO();
        List<Movie> movies = movieJdbcDAO.findByCodeAndRating(currentCategories, currentRatings);

        resultPanel.reset();
        requestPanel.print(movieJdbcDAO.showCurrentSQLQuery());

        if (movies.size() > 0) {
            resultPanel.printResults(movies);
        } else {
            resultPanel.showInfo();
        }
    }
}