import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleComponentTest extends JFrame {

    public SimpleComponentTest() {
        super("Simple component test");
        JPanel cp = new JPanel(new BorderLayout());
        cp.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5),
                BorderFactory.createLineBorder(Color.black)));
        setContentPane(cp);
        cp.add(new SimpleComponent(), BorderLayout.CENTER);
        JButton btn = new JButton("Close");
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        cp.add(btn, BorderLayout.SOUTH);
        cp.setBackground(Color.green);
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JButton button3 = new JButton("Button 3");
        JButton button4 = new JButton("Button 4");

        cp.add(button1, BorderLayout.EAST);
        cp.add(button2, BorderLayout.EAST);
        cp.add(button3, BorderLayout.EAST);
        cp.add(button4, BorderLayout.EAST);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new SimpleComponentTest().setVisible(true);
    }
}