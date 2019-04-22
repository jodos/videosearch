package ch.lab4tech.jav09.gui.top;

import ch.lab4tech.jav09.gui.MainGUI;
import ch.lab4tech.jav09.model.Category;
import ch.lab4tech.jav09.model.Rating;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.util.List;

@Getter
public class FormPanel extends JPanel {

    private LeftTopPanel leftTopPanel;
    private MiddleTopPanel middleTopPanel;
    private RightTopPanel rightTopPanel;

    public FormPanel(MainGUI mainGUI) {
        this.setPreferredSize(new Dimension(800, 200));
        setLayout(new BorderLayout(0, 0));

        leftTopPanel = new LeftTopPanel(mainGUI);
        middleTopPanel = new MiddleTopPanel(mainGUI);
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
