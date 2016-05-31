package ch.lab4tech.jav09;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import ch.lab4tech.jav09.gui.MainGUI;

/**
 *
 * @author Joao
 */
public class JavaVideoSearch {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                } catch (Exception e) {
                }
                new MainGUI();
            }
        });
    }
}
