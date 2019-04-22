package ch.lab4tech.jav09.gui.top;

import ch.lab4tech.jav09.dao.RatingDAO;
import ch.lab4tech.jav09.dao.RatingJdbcDAO;
import ch.lab4tech.jav09.gui.MainGUI;
import ch.lab4tech.jav09.model.Rating;
import lombok.Getter;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Getter
public class MiddleTopPanel extends JPanel {

    private JLabel label;
    private JPanel inner;

    public MiddleTopPanel(MainGUI mainGUI) {
        this.setPreferredSize(new Dimension(266, 200));
        this.setLayout(new BorderLayout(0, 0));
        inner = new JPanel();
        inner.setLayout(new BoxLayout(inner, BoxLayout.Y_AXIS));
        inner.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));

        RatingDAO ratingDA0 = new RatingJdbcDAO();
        final List<Rating> ratings = ratingDA0.find();

        for (Rating codes : ratings) {
            JCheckBox jCheckBox = new JCheckBox(codes.getRating());
            jCheckBox.addItemListener(mainGUI);
            inner.add(jCheckBox);
        }

        label = new JLabel("Codes");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(label, BorderLayout.NORTH);
        this.add(inner, BorderLayout.CENTER);
    }

    public List<Rating> getCurrentRatings() {
        Component[] components = inner.getComponents();
        List<Rating> ratings = new ArrayList<>();
        for (int i = 0; i < components.length; i++) {
            Component currentComponent = components[i];
            if (currentComponent instanceof JCheckBox) {
                JCheckBox jCheckBox = (JCheckBox) currentComponent;
                if (jCheckBox.isSelected()) {
                    Rating rating = new Rating();
                    rating.setRating(jCheckBox.getText());
                    ratings.add(rating);
                }
            }
        }
        return ratings;
    }

    public void reset() {
        Component[] components = inner.getComponents();
        for (int i = 0; i < components.length; i++) {
            Component currentComponent = components[i];
            if (currentComponent instanceof JCheckBox) {
                JCheckBox jCheckBox = (JCheckBox) currentComponent;
                if (jCheckBox.isSelected()) {
                    jCheckBox.setSelected(Boolean.FALSE);
                }
            }
        }
    }

}
