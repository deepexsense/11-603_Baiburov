package java_files.servlets;

import java_files.entities.User;
import java_files.exceptions.FileInteractorException;
import java_files.utils.UserListInteractor;
import java_files.utils.UserListSorter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserTableServlet")
public class UserTableServlet extends HttpServlet {
    public static final String SORT_BY_NAME = "name";
    public static final String SORT_BY_EMAIL = "email";
    public static final String SORT_BY_COUNTRY = "country";
    public static final String SORT_BY_GENDER = "gender";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie defaultSortingCookie = null;
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("sorting_type")) {
                    defaultSortingCookie = cookie;
                }
            }
        }

        String sortingTypeToSet = request.getParameter("sorting_type");


        if(defaultSortingCookie == null) {
            Cookie cookie = new Cookie("sorting_type", sortingTypeToSet);
            response.addCookie(cookie);
        } else {
            defaultSortingCookie.setValue(sortingTypeToSet);
            response.addCookie(defaultSortingCookie);
        }

        response.sendRedirect("/app/usertable");
//        request.getRequestDispatcher("/WEB-INF/views/usertable.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = new ArrayList<>();

        try {
            UserListInteractor userListInteractor = new UserListInteractor(getServletContext().getRealPath("/data/users.csv"));
            users = userListInteractor.getUsers();
        }
        catch (FileInteractorException ex) {
            ex.printStackTrace();
        }

        String defaultSortingType = "";
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("sorting_type")) {
                    defaultSortingType = cookie.getValue();
                }
            }
        }

        request.setAttribute("default_sorting_type", defaultSortingType);

        switch (defaultSortingType) {
            case SORT_BY_NAME:
                request.setAttribute("users", UserListSorter.sortByName(users));
                break;
            case SORT_BY_COUNTRY:
                request.setAttribute("users", UserListSorter.sortByCountry(users));
                break;
            case SORT_BY_EMAIL:
                request.setAttribute("users", UserListSorter.sortByEmail(users));
                break;
            case SORT_BY_GENDER:
                request.setAttribute("users", UserListSorter.sortByGender(users));
                break;
            default:
                request.setAttribute("users", users);
        }

        request.getRequestDispatcher("/WEB-INF/views/usertable.jsp").forward(request, response);
    }
}
