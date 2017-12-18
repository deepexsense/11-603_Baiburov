import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class Main {
    private static final String ABOUT = "Swing app test";
    public final static String TITLE = "Hello";

    public static void main(String[] args) {
        JFrame mainFrame = new JFrame(TITLE);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(createMenu(mainFrame), BorderLayout.NORTH);

        JPanel statusPanel = new JPanel();
        statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        mainFrame.add(statusPanel, BorderLayout.SOUTH);
        statusPanel.setPreferredSize(new Dimension(mainFrame.getWidth(), 16));
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
        JLabel statusLabel = new JLabel("Status");
        statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
        statusPanel.add(statusLabel);

        mainPanel.add(createRightSidebar(statusLabel), BorderLayout.EAST);
        mainPanel.add(createForm(mainFrame), BorderLayout.CENTER);

        mainFrame.getContentPane().add(mainPanel);

        mainFrame.setBounds(100, 50, 600, 400);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
    }

    private static JPanel createForm(JFrame parent) {
        JPanel container = new JPanel();
        int height = 20;

        Dimension fieldDim = new Dimension(150, height);
        Dimension labelDim = new Dimension(100, height);

        JPanel form = new JPanel();
        form.setPreferredSize(new Dimension(500, 110));
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));

        JPanel loginRow = new JPanel(new FlowLayout());
        loginRow.setPreferredSize(new Dimension(500, 20));
        JPanel passwordRow = new JPanel(new FlowLayout());
        passwordRow.setPreferredSize(new Dimension(500, 20));
        JPanel repeatRow = new JPanel(new FlowLayout());
        repeatRow.setPreferredSize(new Dimension(500, 20));

        JLabel loginLabel = new JLabel("Login: ");
        loginLabel.setPreferredSize(labelDim);
        JTextField loginField = new JTextField();
        loginField.setPreferredSize(fieldDim);
        loginRow.add(loginLabel);
        loginRow.add(loginField);

        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setPreferredSize(labelDim);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(fieldDim);
        passwordRow.add(passwordLabel);
        passwordRow.add(passwordField);

        JLabel repeatLabel = new JLabel("Repeat: ");
        repeatLabel.setPreferredSize(labelDim);
        JPasswordField repeatField = new JPasswordField();
        repeatField.setPreferredSize(fieldDim);
        repeatRow.add(repeatLabel);
        repeatRow.add(repeatField);

        JButton confirm = new JButton("Register");
        confirm.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(loginField.getText().isEmpty() || passwordField.getPassword().length == 0 || repeatField.getPassword().length == 0) {
                    return;
                }
                boolean correct = Arrays.equals(passwordField.getPassword(), repeatField.getPassword());
                String title;
                String text;
                Color color;

                if(correct) {
                    title = "Success";
                    text = "You are successfully registered!\r\n" +
                            "Your login: " + loginField.getText();
                    color = new Color(89, 245, 95);
                } else {
                    title = "Error";
                    text = "You aren't registered!\r\n" +
                            "Passwords do not match";
                    color = new Color(245, 42, 0);
                }

                Font font = new Font("Verdana", Font.BOLD, 10);
                JDialog aboutWindow = new JDialog(parent, title, true);
                JPanel container = new JPanel(new BorderLayout(500, 500));
                JLabel jLabel = new JLabel(text, JLabel.CENTER);
                jLabel.setForeground(color);
                jLabel.setFont(font);
                container.add(jLabel);
                container.setBackground(Color.GRAY);
                JDialog.setDefaultLookAndFeelDecorated(true);
                aboutWindow.getContentPane().add(container);
                aboutWindow.setBounds(0, 0, 300, 100);
                aboutWindow.setLocationRelativeTo(parent);
                aboutWindow.setVisible(true);
            }
        });

        form.add(loginRow);
        form.add(passwordRow);
        form.add(repeatRow);
        form.add(confirm);

        container.add(form);

        return container;
    }

    private static JMenuBar createMenu(JFrame parent) {
        JMenuBar navBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem exit = new JMenuItem(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        exit.setText("Exit");
        file.add(exit);
        JButton about = new JButton("About");
        about.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog aboutWindow = new JDialog(parent, "About", true);
                JDialog.setDefaultLookAndFeelDecorated(true);
                aboutWindow.getContentPane().add(new JLabel(ABOUT));
                aboutWindow.setBounds(0, 0, 300, 100);
                aboutWindow.setLocationRelativeTo(parent);
                aboutWindow.setVisible(true);

            }
        });
        navBar.add(file);
        navBar.add(about);
        return navBar;
    }

    private static JPanel createRightSidebar(JLabel statusBar) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JButton button3 = new JButton("Button 3");
        JButton button4 = new JButton("Button 4");

        button1.addMouseListener(new MyMouseAdapter(statusBar, button1));
        button2.addMouseListener(new MyMouseAdapter(statusBar, button2));
        button3.addMouseListener(new MyMouseAdapter(statusBar, button3));
        button4.addMouseListener(new MyMouseAdapter(statusBar, button4));
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        return panel;
    }

    private static class MyMouseAdapter extends MouseAdapter{
        private JLabel statusBar;
        private String buttonText;
        private String defaultText;

        public MyMouseAdapter(JLabel statusBar, JButton button) {
            this.statusBar = statusBar;
            defaultText = statusBar.getText();
            this.buttonText = button.getText();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            statusBar.setText(buttonText);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            statusBar.setText(defaultText);
        }
    }
}
