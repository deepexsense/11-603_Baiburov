import javax.swing.*;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel {
    private JButton addInfoButton = new JButton("Save");

    public ButtonPanel() {
        add(addInfoButton);
    }

    public void addInfoBtnAddActionListener(ActionListener listener) {
        addInfoButton.addActionListener(listener);
    }
}