import java.awt.*;
import javax.swing.*;


public class SimpleTableTest {
    private static void createAndShowUI() {

        JFrame frame = new JFrame("Table");
        frame.getContentPane().add(new Gui(), BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                createAndShowUI();
            }
        });
    }
}

