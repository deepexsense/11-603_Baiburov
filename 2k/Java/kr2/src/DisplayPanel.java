import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DisplayPanel extends JPanel {
    private String[] COLUMNS = {"User Name", "Email"};
    private DefaultTableModel model = new DefaultTableModel(COLUMNS, 0);
    private JTable table = new JTable(model);

    public DisplayPanel() {
        setLayout(new BorderLayout());
        add(new JScrollPane(table));
    }

    public void addRow(String userName, String email) {
        Object[] row = new Object[2];
        row[0] = userName;
        row[1] = email;
        model.addRow(row);
    }
}
