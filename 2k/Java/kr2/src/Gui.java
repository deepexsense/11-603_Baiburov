import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JPanel {
    DisplayPanel displayPanel = new DisplayPanel();
    ButtonPanel buttonPanel = new ButtonPanel();
    InformationPanel informationPanel = new InformationPanel();

    public Gui() {
        JPanel newPanel = new JPanel();
        newPanel.add(Box.createHorizontalStrut(10));
        newPanel.add(informationPanel);
        newPanel.add(buttonPanel);

        setLayout(new BorderLayout());
        add(displayPanel, BorderLayout.CENTER);
        add(newPanel, BorderLayout.NORTH);

        buttonPanel.addInfoBtnAddActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String userName = informationPanel.getUserName();
                String email = informationPanel.getEmail();

                displayPanel.addRow(userName, email);
            }
        });
    }
}