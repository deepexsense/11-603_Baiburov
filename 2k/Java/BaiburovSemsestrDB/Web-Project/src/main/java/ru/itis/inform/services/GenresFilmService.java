package ru.itis.inform.services;

import java.util.LinkedList;

//Все это сервисы с управлениями ДАО

public interface GenresFilmService {
    boolean addGenresOnFilm(String roles, int filmId);
    LinkedList getGenreIdByFilmId(int filmId);
}
