package ch.lab4tech.jav09.gui.middle;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class RequestPanel extends JScrollPane {
	private JTextPane textPane;

	public RequestPanel(JFrame mainGUI) {
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

	public JTextPane getTextPane() {
		return textPane;
	}

	public void setTextPane(JTextPane textPane) {
		this.textPane = textPane;
	}
}