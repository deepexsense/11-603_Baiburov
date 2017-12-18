package ru.itis.inform.services;

import ru.itis.inform.models.Genre;

import java.util.LinkedList;

//Все это сервисы с управлениями ДАО
public interface GenreService {
    boolean addGenre(Genre genre);
    Genre getGenre(String name);
    LinkedList<Genre> getGenres();
    Genre getGenreById(int id);
}
