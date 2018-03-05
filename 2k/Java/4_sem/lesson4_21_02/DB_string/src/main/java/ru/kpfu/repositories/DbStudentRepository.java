package ru.kpfu.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import ru.kpfu.models.Student;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("database")
public class DbStudentRepository implements StudentRepository {
    private Connection connection;

    public static final String SELECT_ALL = "SELECT id, name, surname FROM students";
    public static final String SELECT_BY_ID = "SELECT id, name, surname FROM students WHERE id = ?";
    @Autowired
    public DbStudentRepository(DataSource dataSource) throws SQLException {
        connection = dataSource.getConnection();
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet r = null;
        try {
            st = connection.prepareStatement(SELECT_ALL);
            r = st.executeQuery();
            while(r.next()){
                students.add(Student.builder()
                        .id(r.getLong("id"))
                        .name(r.getString("name"))
                        .surname(r.getString("surname"))
                        .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public Student getStudentById(Long id) {
        List<Student> students = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet r = null;
        try {
            st = connection.prepareStatement(SELECT_BY_ID);
            st.setLong(1, id);
            r = st.executeQuery();
            while(r.next()){
                students.add(Student.builder()
                        .id(r.getLong("id"))
                        .name(r.getString("name"))
                        .surname(r.getString("surname"))
                        .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(students.size() > 0) {
            return students.get(0);
        }
        return null;
    }
}
