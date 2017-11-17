package java_files.validators;

import java_files.exceptions.NotEqualPasswordsException;

import javax.servlet.http.HttpServletRequest;

public class RegistrationValidator {
    public static void validatePasswords(HttpServletRequest req) throws NotEqualPasswordsException {
        String password = req.getParameter("password");
        String passwordCheck = req.getParameter("repeat");

        if(!password.equals(passwordCheck)) {
            throw new NotEqualPasswordsException();
        }
    }
}
