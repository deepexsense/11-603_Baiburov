package java_files.utils;

import java_files.exceptions.FileInteractorException;
import java_files.entities.User;
import java_files.exceptions.NotCorrectLoginDataException;
import java_files.exceptions.UserAlreadyExistException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserListInteractor {
    private String path;
    private List<User> users;

    public UserListInteractor(String path) throws FileInteractorException {
        this.path = path;
        this.users = readAll();
    }

    public List<User> getUsers() throws FileInteractorException{
        users = readAll();
        return users;
    }

    public User getUser(String email) {
        for (User u : users) {
            if (u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;
    }

    public void addUser(User user) throws UserAlreadyExistException, FileInteractorException {
        try {
            checkUserRegistration(user.getEmail());

            users.add(user);

            String[] data = new String[] {
                    user.getEmail(),
                    user.getPassword(),
                    user.getName(),
                    user.getCountry(),
                    user.getGender(),
                    user.getSubscribe()?"1":"0"
            };
            CSVInteractor.add(data, new FileWriter(path, true));
        } catch (IOException e) {
            throw new FileInteractorException();
        }
    }

    private void checkUserRegistration(String email) throws UserAlreadyExistException{
        for (User user: users) {
            if(user.getEmail().equals(email)) {
                throw new UserAlreadyExistException();
            }
        }
    }

    public void checkUserLogin(String email, String password) throws NotCorrectLoginDataException {
        boolean found = false;
        for (User user: users) {
            if(user.getEmail().equals(email) && !user.getPassword().equals(password)) {
                throw new NotCorrectLoginDataException();
            }
            else if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
                found = true;
            }
        }
        if(!found) {
            throw new NotCorrectLoginDataException();
        }
    }

    private List<User> readAll() throws FileInteractorException{
        List<String[]> myEntries = new ArrayList<>();
        try {
            myEntries = CSVInteractor.getAll(new FileReader(path));
        } catch (IOException e) {
            throw new FileInteractorException();
        }
        List<User> users = new ArrayList<>();
        for(String[] s : myEntries) {
            User user = User.builder()
                    .email(s[0])
                    .password(s[1])
                    .name(s[2])
                    .country(s[3])
                    .gender(s[4])
                    .subscribe(s[5].equals("1"))
                    .build();
            users.add(user);
        }
        return users;
    }
}
