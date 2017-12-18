package ru.itis.inform.dao;

import ru.itis.inform.models.Genre;

import java.util.LinkedList;

public interface GenreFilmDao {
    //Получить список моделей жанр-фильм по айди фильма.
    LinkedList getGenreIdByFilmId(int filmId);

    //Добавить фильм-жанр зависимость много к многому.
    boolean addGenresOnFilm(int genreId, int filmId);
}
