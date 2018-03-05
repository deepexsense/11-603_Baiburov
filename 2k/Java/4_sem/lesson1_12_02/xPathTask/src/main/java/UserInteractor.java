import java.io.IOException;

public class UserInteractor {

    public static void inter(){
            SysOut.println("Введите URL:");
            String html = "";
            try {
                html = WebConnection.getWebPabeSource(SysIn.read());
            } catch (IOException e) {
                e.printStackTrace();
            }
            SysOut.println("Введите xPath:");
            Parser.pars(html, SysIn.read());
    }
}
