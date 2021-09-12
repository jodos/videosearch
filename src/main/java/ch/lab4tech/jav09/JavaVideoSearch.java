package ch.lab4tech.jav09;

import ch.lab4tech.jav09.gui.MainGUI;

import javax.swing.*;


public class JavaVideoSearch {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            } catch (Exception e) {
            }
            new MainGUI();
        });
    }
}