package ch.lab4tech.jav09.gui.bottom;

import ch.lab4tech.jav09.model.Movie;
import lombok.Getter;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

@Getter
public class ResultPanel extends JPanel {

    private final JLabel resultPanelLabel;
    private final JScrollPane scrollPane;
    private final JTable table;
    private final DefaultTableModel tableModel;
    private final JTextPane textPane;

    public ResultPanel() {
        this.setLayout(new BorderLayout(0, 0));
        this.setPreferredSize(new Dimension(800, 200));

        resultPanelLabel = new JLabel("Result");
        scrollPane = new JScrollPane();
        table = new JTable();
        table.setEnabled(Boolean.FALSE);
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
            tableModel.addRow(new Object[]{movie.getTitle(), movie.getRating(), movie.getCategoryCode(), movie.getDescription()});
        }
    }

    public void showInfo() {
        textPane.setText("Aucun film ne correspond au(x) critères sélectionné(s)");
    }
}