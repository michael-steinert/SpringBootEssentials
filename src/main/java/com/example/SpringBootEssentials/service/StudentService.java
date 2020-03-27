package com.example.SpringBootEssentials.service;

import com.example.SpringBootEssentials.dao.StudentDao;
import com.example.SpringBootEssentials.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentDao studentDao;

    @Autowired
    public StudentService(@Qualifier("fakeDao") StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public int persistNewStudent(UUID studentId, Student newStudent){
        Optional<UUID> studentUuid = Optional.of(studentId);
        UUID studentid = (studentUuid.isEmpty() ? UUID.randomUUID() : studentUuid.get());
        Optional<Student> student = Optional.ofNullable(newStudent);
        if(student.isEmpty()) {
            throw new IllegalStateException("Student ist falsch");
        }
        student.get().setId(studentid);
        return studentDao.insertNewStudent(studentid, student.get());
    }

    public Student getStudentById(UUID studentId) {
       Optional<Student> student = Optional.ofNullable(studentDao.selectStudentById(studentId));
        if(student.isEmpty()) {
            throw new IllegalStateException("StudentID ist falsch");
        }
        return student.get();
    }

    public List<Student> getAllStudents() {
        Optional<List<Student>> studentList = Optional.ofNullable(studentDao.selectAllStudents());
        if(studentList.isEmpty()){
            throw new NoSuchElementException("Liste ist leer");
        }
        return studentList.get();
    }

    public int updateStudentById(UUID studentId, Student updateStudent) {
        Optional<UUID> studentid = Optional.ofNullable(studentId);
        Optional<Student> student = Optional.ofNullable(updateStudent);
        if(studentid.isEmpty() || student.isEmpty()) {
            throw new IllegalStateException("StudentID oder Student ist falsch");
        }
        return studentDao.updateStudentById(studentid.get(), student.get());
    }

    public int deleteStudentById(UUID studentId) {
        Optional<Student> student = Optional.ofNullable(getStudentById(studentId));
        if(student.isEmpty()) {
            throw new IllegalStateException("StudentID ist falsch");
        }
        return studentDao.deleteStudentById(student.get().getId());
    }
}
