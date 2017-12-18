package ru.itis.inform.dao;

import ru.itis.inform.models.Genre;

import java.util.LinkedList;

public interface GenreDao {
    //Добавить жанр
    boolean addGenre(Genre genre);

    //Получить модель жанра
    Genre getGenre(String name);

    //Получить список моделей жанра
    LinkedList<Genre> getGenres();

    //Получить модель жанра по айди
    Genre getGenreById(int id);

    void deleteGenre(int id);
}
