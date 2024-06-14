package ch.lab4tech.jav09.gui.top;

import ch.lab4tech.jav09.gui.MainGUI;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import lombok.Getter;

@Getter
public class RightTopPanel extends JPanel {

	private final JLabel label;
	private final JPanel inner;
	private final ButtonGroup buttonGroup;
	private final JRadioButton auto;
	private final JRadioButton noAuto;
	private final JButton request;
	private final JButton clear;

	public RightTopPanel(MainGUI mainGUI) {
		this.setPreferredSize(new Dimension(266, 200));
		this.setLayout(new BorderLayout(0, 0));
		label = new JLabel("Request");
		label.setHorizontalAlignment(SwingConstants.CENTER);

		inner = new JPanel();
		inner.setLayout(new BoxLayout(inner, BoxLayout.Y_AXIS));
		inner.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		buttonGroup = new ButtonGroup();
		auto = new JRadioButton("AutoRequery");
		auto.setAlignmentX(Component.CENTER_ALIGNMENT);
		auto.setHorizontalAlignment(SwingConstants.CENTER);
		auto.setSelected(true);
		noAuto = new JRadioButton("NoAutoRequery");
		noAuto.setAlignmentX(Component.CENTER_ALIGNMENT);
		noAuto.setHorizontalAlignment(SwingConstants.CENTER);

		auto.addActionListener(mainGUI);
		noAuto.addActionListener(mainGUI);

		buttonGroup.add(auto);
		buttonGroup.add(noAuto);
		request = new JButton("Requery");
		request.setAlignmentX(Component.CENTER_ALIGNMENT);
		clear = new JButton("Clear");
		clear.setAlignmentX(Component.CENTER_ALIGNMENT);

		request.addActionListener(mainGUI);
		clear.addActionListener(mainGUI);

		inner.add(auto);
		inner.add(noAuto);
		inner.add(request);
		inner.add(clear);

		this.add(label, BorderLayout.NORTH);
		this.add(inner, BorderLayout.CENTER);
	}

	public void resetRequestButton() {
		Component[] components = inner.getComponents();
		for (Component component : components) {
			if (component instanceof JButton button && button.getText().equals("Requery")) {
				JButton jButton = new JButton();
				button.setBackground(jButton.getBackground());
				button.setForeground(jButton.getForeground());
			}
		}
	}

	public boolean isAuto() {
		return auto.isSelected();
	}
}
