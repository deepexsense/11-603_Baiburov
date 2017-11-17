package java_files.validators;

import java_files.exceptions.NotCorrectLoginDataException;
import java_files.utils.UserListInteractor;

public class LoginValidator {
    public static boolean validateLoginPair(String email, String password, UserListInteractor userListInteractor) {
        try {
            userListInteractor.checkUserLogin(email, password);
        } catch (NotCorrectLoginDataException e) {
            return false;
        }
        return true;
    }
}
