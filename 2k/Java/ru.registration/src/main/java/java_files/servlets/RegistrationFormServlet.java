package java_files.servlets;

import java_files.exceptions.FileInteractorException;
import java_files.exceptions.NotEqualPasswordsException;
import java_files.exceptions.UserAlreadyExistException;
import java_files.utils.UserListInteractor;
import java_files.entities.User;
import java_files.validators.RegistrationValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RegistrationFormServlet")
public class RegistrationFormServlet extends HttpServlet {
    private UserListInteractor userListInteractor;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String country = request.getParameter("selectCountry");
        String gender = request.getParameter("gender");
        Boolean subscribe = "checked".equals(request.getParameter("subscribe"));
        HttpSession session = request.getSession();

        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type", "text/html; charset=utf-8");

        try {
            RegistrationValidator.validatePasswords(request);
        } catch (NotEqualPasswordsException ex) {
            session.setAttribute("passwords_not_equal", "Passwords don't equal");
            response.sendRedirect("/app/registration");
            return;
        }

        try {
            userListInteractor = new UserListInteractor(getServletContext().getRealPath("/data/users.csv"));
            User user = User.builder()
                    .email(email)
                    .password(password)
                    .name(name)
                    .country(country)
                    .subscribe(subscribe)
                    .gender(gender)
                    .build();
            userListInteractor.addUser(user);
        }
        catch (UserAlreadyExistException e) {
            session.setAttribute("user_already_exist", "This email has already used");
            response.sendRedirect("/app/registration");
            return;
        }
        catch (FileInteractorException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/app/login");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setAttribute("passwords_not_equal", session.getAttribute("passwords_not_equal"));
        request.setAttribute("user_already_exist", session.getAttribute("user_already_exist"));

        session.setAttribute("passwords_not_equal", null);
        session.setAttribute("user_already_exist", null);
        request.getRequestDispatcher("/WEB-INF/views/registration.jsp").forward(request, response);
    }
}
