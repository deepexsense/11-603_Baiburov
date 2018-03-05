package ru.kpfu.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.models.Student;
import ru.kpfu.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student getById(Long id) {
        if(id != null) {
            Student student = studentRepository.getStudentById(id);
            if(student != null) {
                return student;
            }
        }
        return null;
    }
}
