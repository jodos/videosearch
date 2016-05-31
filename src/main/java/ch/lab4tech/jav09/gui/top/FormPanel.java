package ch.lab4tech.jav09.gui.top;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JPanel;

import ch.lab4tech.jav09.gui.MainGUI;
import ch.lab4tech.jav09.model.Category;
import ch.lab4tech.jav09.model.Rating;

@SuppressWarnings("serial")
public class FormPanel extends JPanel {

	LeftTopPanel leftTopPanel;
	MiddleTopPanel middleTopPanel;
	RightTopPanel rightTopPanel;

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

	public LeftTopPanel getLeftTopPanel() {
		return leftTopPanel;
	}

	public void setLeftTopPanel(LeftTopPanel leftTopPanel) {
		this.leftTopPanel = leftTopPanel;
	}

	public MiddleTopPanel getMiddleTopPanel() {
		return middleTopPanel;
	}

	public void setMiddleTopPanel(MiddleTopPanel middleTopPanel) {
		this.middleTopPanel = middleTopPanel;
	}

	public RightTopPanel getRightTopPanel() {
		return rightTopPanel;
	}

	public void setRightTopPanel(RightTopPanel rightTopPanel) {
		this.rightTopPanel = rightTopPanel;
	}
}