package ru.kpfu.repositories;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import ru.kpfu.models.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Profile("map")
public class SimpleStudentRepository implements StudentRepository {
    private Map<Long, Student> studentMap;
    public SimpleStudentRepository() {
        studentMap = new HashMap<>();
        fill();
    }

    private void fill() {
        Student student1 = Student.builder()
                .name("Airat")
                .surname("Baiburov not from db")
                .id(0L)
                .build();
        Student student2 = Student.builder()
                .name("Ivan")
                .surname("Ivanov not from db")
                .id(1L)
                .build();
        Student student3 = Student.builder()
                .name("Dmitriy")
                .surname("Dmitriyev not from db")
                .id(2L)
                .build();
        studentMap.put(student1.getId(), student1);
        studentMap.put(student2.getId(), student2);
        studentMap.put(student3.getId(), student3);
    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<Student>(studentMap.values());
    }

    @Override
    public Student getStudentById(Long id) {
        return studentMap.get(id);
    }
}
