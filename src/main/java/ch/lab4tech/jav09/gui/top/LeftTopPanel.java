package ch.lab4tech.jav09.gui.top;

import ch.lab4tech.jav09.gui.MainGUI;
import ch.lab4tech.jav09.model.Category;
import ch.lab4tech.jav09.repository.CategoryRepository;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

@Getter
public class LeftTopPanel extends JPanel {

  private final JLabel label;
  private final JScrollPane scrollPane;
  private final JList list;

  public LeftTopPanel(MainGUI mainGUI, CategoryRepository categoryRepository) {
    this.setPreferredSize(new Dimension(266, 200));
    this.setLayout(new BorderLayout(0, 0));
    label = new JLabel("Catégorie");
    label.setHorizontalAlignment(SwingConstants.CENTER);

    final List<Category> categories = categoryRepository.findAll();
    scrollPane = new JScrollPane();
    list = new JList(new Vector<>(entityToString(categories)));
    scrollPane.setViewportView(list);
    list.addListSelectionListener(mainGUI);

    this.add(label, BorderLayout.NORTH);
    this.add(scrollPane, BorderLayout.CENTER);
  }

  public List<Category> getCurrentCategories() {
    int[] indices = list.getSelectedIndices();
    List<Category> categories = new ArrayList<>(indices.length);
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

  private List<String> entityToString(List<Category> categories) {
    final List<String> l = new ArrayList<>(categories.size());

    for (Category c : categories) {
      l.add(c.getDescription());
    }
    return l;
  }
}
