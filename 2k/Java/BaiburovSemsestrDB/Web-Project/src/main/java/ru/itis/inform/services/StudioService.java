package ru.itis.inform.services;

import ru.itis.inform.models.Studio;

import java.util.LinkedList;

//Все это сервисы с управлениями ДАО
public interface StudioService {
    Studio getStudioByFilmId(int id);
    boolean addStudio(Studio studio);
    Studio getStudio(String name);
    LinkedList<Studio> getAllStudio();
}
