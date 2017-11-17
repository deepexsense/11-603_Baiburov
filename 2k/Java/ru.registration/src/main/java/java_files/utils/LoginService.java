package java_files.utils;

import org.jasypt.util.text.BasicTextEncryptor;
import java_files.validators.LoginValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginService {
    public static void login(HttpServletRequest request, HttpServletResponse response, UserListInteractor userListInteractor) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");
        if (user != null) {
            response.sendRedirect("/app/success");
        } else {
            user = CookieInteractor.getCookieValue(request, "user");
            if(user != null) {
                BasicTextEncryptor encryptor = new BasicTextEncryptor();
                encryptor.setPassword("qwe21");
                String decryptedUser = encryptor.decrypt(user);
                String password = userListInteractor.getUser(decryptedUser).getPassword();

                if((password != null) && (LoginValidator.validateLoginPair(decryptedUser, password, userListInteractor))) {
                    CookieInteractor.addCookie(response, "user", user, 60 * 60 * 24 * 30);
                    response.sendRedirect("/app/success");
                }
                else {
                    CookieInteractor.removeCookie(response, "user");
                    request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
                }
            }
            else {
                request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
            }
        }
    }
}
