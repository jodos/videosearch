package ch.lab4tech.jav09.gui.top;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import ch.lab4tech.jav09.gui.MainGUI;

@SuppressWarnings("serial")
public class RightTopPanel extends JPanel {

    private JLabel label;
    private JPanel inner;
    private ButtonGroup buttonGroup;
    private JRadioButton auto;
    private JRadioButton noAuto;
    private JButton request;
    private JButton clear;

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
        for (int i = 0; i < components.length; i++) {
            Component component = components[i];
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                if (button.getText().equals("Requery")) {
                    JButton jButton = new JButton();
                    button.setBackground(jButton.getBackground());
                    button.setForeground(jButton.getForeground());
                }
            }
        }
    }

    public boolean isAuto() {
        return auto.isSelected();
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public JPanel getInner() {
        return inner;
    }

    public void setInner(JPanel inner) {
        this.inner = inner;
    }

    public ButtonGroup getButtonGroup() {
        return buttonGroup;
    }

    public void setButtonGroup(ButtonGroup buttonGroup) {
        this.buttonGroup = buttonGroup;
    }

    public JRadioButton getAuto() {
        return auto;
    }

    public void setAuto(JRadioButton auto) {
        this.auto = auto;
    }

    public JRadioButton getNoAuto() {
        return noAuto;
    }

    public void setNoAuto(JRadioButton noAuto) {
        this.noAuto = noAuto;
    }

    public JButton getRequest() {
        return request;
    }

    public void setRequest(JButton request) {
        this.request = request;
    }

    public JButton getClear() {
        return clear;
    }

    public void setClear(JButton clear) {
        this.clear = clear;
    }
}