package ch.lab4tech.jav09.gui.bottom;

import ch.lab4tech.jav09.gui.MainGUI;
import ch.lab4tech.jav09.model.Movie;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import lombok.Data;

@Data
@SuppressWarnings("serial")
public class ResultPanel extends JPanel {

    private JLabel resultPanelLabel;
    private JScrollPane scrollPane;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextPane textPane;

    public ResultPanel(MainGUI mainGUI) {
        this.setLayout(new BorderLayout(0, 0));
        this.setPreferredSize(new Dimension(800, 200));

        resultPanelLabel = new JLabel("Result");
        scrollPane = new JScrollPane();
        table = new JTable();
        tableModel = new DefaultTableModel();
        textPane = new JTextPane();
        textPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));

        String[] jTableHeader = {"Title", "Rating", "CategoryCode", "Description"};
        tableModel.setColumnIdentifiers(jTableHeader);
        table.setModel(tableModel);
        scrollPane.setViewportView(table);
        textPane.setEditable(Boolean.FALSE);
        textPane.setForeground(Color.RED);

        this.add(resultPanelLabel, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
        this.add(textPane, BorderLayout.SOUTH);
    }

    public void reset() {
        tableModel.setRowCount(0);
        textPane.setText("");
    }

    public void printResults(List<Movie> movies) {
        for (Movie movie : movies) {
            tableModel.addRow(new Object[]{movie.getTitle(), movie.getRating(), movie.getCategoryCode(),
                movie.getDescription()});
        }
    }

    public void showInfo() {
        textPane.setText("Aucun film ne correspond au(x) critères sélectionné(s)");
    }

}
