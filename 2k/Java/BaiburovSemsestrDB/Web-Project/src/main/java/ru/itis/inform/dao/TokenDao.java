package ru.itis.inform.dao;

public interface TokenDao {
    //Защита системы
    //Добавление токена айди и самого токена
    void addToken(String id, String token);
    //Обновление токена
    void updateToken(String id, String token);
    //Удаление токена
    void deleteToken(String token);
    //Поиск токена
    String findToken(String token);
}
