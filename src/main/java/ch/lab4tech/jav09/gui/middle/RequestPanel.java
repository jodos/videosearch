package ch.lab4tech.jav09.gui.middle;

import javax.swing.*;
import lombok.Getter;

@Getter
public class RequestPanel extends JScrollPane {

	private final JTextPane textPane;

	public RequestPanel() {
		textPane = new JTextPane();
		textPane.setEditable(Boolean.FALSE);
		this.setViewportView(textPane);
	}

	public void reset() {
		textPane.setText("");
	}

	// TODO implement print method
	public void print(String request) {
		reset();
		textPane.setText(request);
	}
}
