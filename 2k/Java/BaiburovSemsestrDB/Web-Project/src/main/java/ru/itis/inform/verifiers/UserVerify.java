package ru.itis.inform.verifiers;

import ru.itis.inform.dao.UserDao;
import ru.itis.inform.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;

//Чек есть ли юзер в бд
public class UserVerify {
    public static User checkUserInBD(UserDao userDao, String login) {
        return userDao.findUser(login);
    }
}
