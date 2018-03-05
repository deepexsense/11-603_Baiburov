package ru.kpfu.repositories;


import ru.kpfu.models.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> getAllStudents();
    Student getStudentById(Long id);
}
