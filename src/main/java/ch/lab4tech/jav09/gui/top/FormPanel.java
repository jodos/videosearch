package ch.lab4tech.jav09.gui.top;

import ch.lab4tech.jav09.gui.MainGUI;
import ch.lab4tech.jav09.model.Category;
import ch.lab4tech.jav09.model.Rating;
import ch.lab4tech.jav09.repository.CategoryRepository;
import ch.lab4tech.jav09.repository.RatingRepository;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.util.List;

@Getter
public class FormPanel extends JPanel {

  private final LeftTopPanel leftTopPanel;
  private final MiddleTopPanel middleTopPanel;
  private final RightTopPanel rightTopPanel;

  public FormPanel(
      MainGUI mainGUI, CategoryRepository categoryRepository, RatingRepository ratingRepository) {
    this.setPreferredSize(new Dimension(800, 200));
    setLayout(new BorderLayout(0, 0));

    leftTopPanel = new LeftTopPanel(mainGUI, categoryRepository);
    middleTopPanel = new MiddleTopPanel(mainGUI, ratingRepository);
    rightTopPanel = new RightTopPanel(mainGUI);

    this.add(leftTopPanel, BorderLayout.WEST);
    this.add(middleTopPanel, BorderLayout.CENTER);
    this.add(rightTopPanel, BorderLayout.EAST);
  }

  public void reset() {
    leftTopPanel.reset();
    middleTopPanel.reset();
  }

  public boolean isAuto() {
    return rightTopPanel.isAuto();
  }

  public List<Category> getCurrentCategories() {
    return leftTopPanel.getCurrentCategories();
  }

  public List<Rating> getCurrentRatings() {
    return middleTopPanel.getCurrentRatings();
  }
}
