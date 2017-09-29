package ch.lab4tech.jav09.gui.top;

import ch.lab4tech.jav09.dao.CategoryDAO;
import ch.lab4tech.jav09.dao.CategoryJdbcDAO;
import ch.lab4tech.jav09.gui.MainGUI;
import ch.lab4tech.jav09.model.Category;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import lombok.Data;

@Data
@SuppressWarnings("serial")
public class LeftTopPanel extends JPanel {

    private JLabel label;
    private JScrollPane scrollPane;
    private JList list;

    public LeftTopPanel(MainGUI mainGUI) {
        this.setPreferredSize(new Dimension(266, 200));
        this.setLayout(new BorderLayout(0, 0));
        label = new JLabel("Catégorie");
        label.setHorizontalAlignment(SwingConstants.CENTER);

        CategoryDAO categoryDAO = new CategoryJdbcDAO();
        final List<String> categories = categoryDAO.find();

        scrollPane = new JScrollPane();
        list = new JList(new Vector<String>(categories));
        scrollPane.setViewportView(list);
        list.addListSelectionListener(mainGUI);

        this.add(label, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
    }

    public List<Category> getCurrentCategories() {
        int[] indices = list.getSelectedIndices();
        List<Category> categories = new ArrayList<Category>(indices.length);
        for (int i = 0; i < indices.length; i++) {
            Category category = new Category();
            category.setCode(indices[i] + 1);
            categories.add(category);
        }
        return categories;
    }

    public void reset() {
        list.clearSelection();
    }
}
