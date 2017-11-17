package java_files.servlets;

import java_files.exceptions.FileInteractorException;
import java_files.utils.CookieInteractor;
import java_files.utils.LoginService;
import java_files.utils.UserListInteractor;
import java_files.validators.LoginValidator;
import org.jasypt.util.text.BasicTextEncryptor;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        boolean remember = "checked".equals(request.getParameter("remember"));
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");

        if (user != null) {
            response.sendRedirect("/app/success");
        } else {
            try {
                UserListInteractor userListInteractor = new UserListInteractor(getServletContext().getRealPath("/data/users.csv"));
                if(LoginValidator.validateLoginPair(email, password, userListInteractor)) {
                    BasicTextEncryptor encryptor = new BasicTextEncryptor();
                    encryptor.setPassword("qwe21");
                    String encryptedEmail = encryptor.encrypt(email);
                    session.setAttribute("user", encryptedEmail);

                    if(remember) {
                        CookieInteractor.addCookie(response, "user", encryptedEmail, 60 * 60 * 24 * 30);
                    }
                    else {
                        CookieInteractor.removeCookie(response, "user");
                    }
                    response.sendRedirect("/app/success");
                } else {
                    response.sendRedirect("/app/login");
                }
            } catch (FileInteractorException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UserListInteractor userListInteractor = new UserListInteractor(getServletContext().getRealPath("/data/users.csv"));
            LoginService.login(request, response, userListInteractor);
        } catch (FileInteractorException e) {
            e.printStackTrace();
        }
    }

}
