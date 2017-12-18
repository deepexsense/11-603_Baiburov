import java.awt.Image;
import javax.swing.GrayFilter;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class CreateDiabledVersionOfanImage {
    public static void main(String[] a) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("image.jpg");
        Image normalImage = icon.getImage();
        Image grayImage = GrayFilter.createDisabledImage(normalImage);
        Icon warningIcon = new ImageIcon(grayImage);
        JLabel warningLabel = new JLabel(warningIcon);
        JLabel label3 = new JLabel("Warning", icon, JLabel.CENTER);
        frame.add(warningLabel,"Center");
        frame.add(label3,"South");
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}

