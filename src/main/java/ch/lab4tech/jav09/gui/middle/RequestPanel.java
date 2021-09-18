package ch.lab4tech.jav09.gui.middle;

import ch.lab4tech.jav09.gui.MainGUI;
import lombok.Getter;

import javax.swing.*;

@Getter
public class RequestPanel extends JScrollPane {

  private final JTextPane textPane;

  public RequestPanel(MainGUI mainGUI) {
    textPane = new JTextPane();
    textPane.setEditable(Boolean.FALSE);
    this.setViewportView(textPane);
  }

  public void reset() {
    textPane.setText("");
  }

  public void print(String request) {
    reset();
    textPane.setText(request);
  }
}
