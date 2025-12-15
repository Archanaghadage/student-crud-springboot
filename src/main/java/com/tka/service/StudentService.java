package com.tka.service;

import java.util.List;

import com.tka.Entity.StudentEntity;

public interface StudentService {

    List<StudentEntity> getAllStudents();

    StudentEntity getStudentById(Long id);

    StudentEntity addStudent(StudentEntity student);

    StudentEntity updateStudent(Long id, StudentEntity student);

    void deleteStudent(Long id);
}
