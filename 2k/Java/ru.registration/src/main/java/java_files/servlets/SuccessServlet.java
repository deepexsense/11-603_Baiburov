package java_files.servlets;

import org.jasypt.util.text.BasicTextEncryptor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SuccessServlet")
public class SuccessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String encryptedUser = (String) session.getAttribute("user");
        String decryptedUser = "";
        if(encryptedUser != null) {
            BasicTextEncryptor encryptor = new BasicTextEncryptor();
            encryptor.setPassword("qwe21");
            decryptedUser = encryptor.decrypt(encryptedUser);
        }

        request.setAttribute("email", decryptedUser);
        request.getRequestDispatcher("/WEB-INF/views/success.jsp").forward(request, response);
    }
}
