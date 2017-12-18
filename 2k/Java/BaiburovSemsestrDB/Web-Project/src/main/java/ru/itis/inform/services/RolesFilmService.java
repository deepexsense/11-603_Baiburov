package ru.itis.inform.services;

import java.util.LinkedList;

//Все это сервисы с управлениями ДАО
public interface RolesFilmService {
    boolean addRolesOnFilm(String roles, int filmId);
    LinkedList getRoleIdByFilmId(int id);
}
