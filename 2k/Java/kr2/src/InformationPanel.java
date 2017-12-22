import javax.swing.*;
import java.net.URL;
import java.net.URLConnection;

public class InformationPanel extends JPanel {
    private JTextField userNameField = new JTextField(10);
    private JTextField emailField = new JTextField(10);

    public InformationPanel() {
        add(new JLabel("User Name: "));
        add(userNameField);
        add(Box.createHorizontalStrut(10));
        add(new JLabel("Email: "));
        add(emailField);
    }

    public String getUserName() {
        public void getJSONEmployees() {
            try {
                Client cl = Client.create();
                WebResource webResource = cl
                        .resource("http://localhost:3000/information");
                ClientResponse response = webResource.accept("application/json")
                        .get(ClientResponse.class);

                if (response.getStatus() != 200) {
                    System.out.println("no out put");
                    throw new RuntimeException("Failed : HTTP error code : "
                            + response.getStatus());
                }

                String output = response.getEntity(String.class);
                // String[] output = response.getEntity(String.);
                System.out.println("\n -------");
                System.out.println(output);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return emailField.getText();
    }

    public String getEmail() {
        return userNameField.getText();
    }
}