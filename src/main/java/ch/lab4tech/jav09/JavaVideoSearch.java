package ch.lab4tech.jav09;

import ch.lab4tech.jav09.gui.MainGUI;

import javax.swing.*;


public class JavaVideoSearch {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            } catch (Exception e) {
            }
            new MainGUI();
        });
    }
}