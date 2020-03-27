package com.example.SpringBootEssentials.service;

import com.example.SpringBootEssentials.dao.StudentDao;
import com.example.SpringBootEssentials.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

public class StudentService {

    private final StudentDao studentDao;

    @Autowired
    public StudentService(@Qualifier("fakeDao") StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public int persistNewStudent(UUID studentId, Student student){
        Optional<UUID> studentUuid = Optional.of(studentId);
        UUID studentid = (studentUuid.isEmpty() ? UUID.randomUUID() : studentUuid.get());
        return studentDao.insertNewStudent(studentid, student);
    }

    public Student getStudentById(UUID studentId) {
        Optional<Student> student = Optional.ofNullable(getStudentById(studentId));
        if(student.isEmpty()) {
            throw new IllegalStateException("StudentID ist falsch");
        }
        return studentDao.selectStudentById(studentId);
    }

    public List<Student> getAllStudents() {
        Optional<List<Student>> studentList = Optional.ofNullable(studentDao.selectAllStudents());
        if(studentList.isEmpty()){
            throw new NoSuchElementException("Liste ist leer");
        }
        return studentList.get();
    }

    public int updateStudentById(UUID studentId, Student studentUpdate) {
        Optional<Student> student = Optional.ofNullable(getStudentById(studentId));
        if(student.isEmpty()) {
            throw new IllegalStateException("StudentID ist falsch");
        }
        return studentDao.updateStudentById(studentId, studentUpdate);
    }

    public int deleteStudentById(UUID studentId) {
        Optional<Student> student = Optional.ofNullable(getStudentById(studentId));
        if(student.isEmpty()) {
            throw new IllegalStateException("StudentID ist falsch");
        }
        return studentDao.deleteStudentById(studentId);
    }
}
