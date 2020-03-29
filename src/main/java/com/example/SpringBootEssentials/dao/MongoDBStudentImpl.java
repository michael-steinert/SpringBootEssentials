package com.example.SpringBootEssentials.dao;

import com.example.SpringBootEssentials.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("mongoDbDao")
public class MongoDBStudentImpl implements StudentDao {

    //Objekt, welches CRUD-Operationen erlaubt
    //private final MongoDbTemplate mongoDbTemplate;

    @Override
    public int insertNewStudent(UUID studentId, Student student) {
        return 0;
    }

    @Override
    public Student selectStudentById(UUID studentId) {
        return null;
    }

    @Override
    public List<Student> selectAllStudents() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(UUID.randomUUID(), 10, "Mongo", "DB","Kurs"));
        return null;
    }

    @Override
    public int updateStudentById(UUID studentId, Student studentUpdate) {
        return 0;
    }

    @Override
    public int deleteStudentById(UUID studentId) {
        return 0;
    }
}
