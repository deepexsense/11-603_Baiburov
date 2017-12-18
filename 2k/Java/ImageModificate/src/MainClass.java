import java.awt.Image;
import javax.swing.ImageIcon;
public class MainClass {
    public static void main(String[] a) {
        ImageIcon imageIcon = new ImageIcon("yourFile.gif");
        Image image = imageIcon.getImage();
    }
}
