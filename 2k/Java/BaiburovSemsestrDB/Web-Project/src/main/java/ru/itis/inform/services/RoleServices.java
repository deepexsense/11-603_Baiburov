package ru.itis.inform.services;

import ru.itis.inform.models.Genre;
import ru.itis.inform.models.Role;

import java.util.List;

//Все это сервисы с управлениями ДАО
public interface RoleServices {
    boolean addRole(Role role);
    Role getRole(String name);
    List<Role> getAllRoles();

    Role getRoleById(int roleId);
}
