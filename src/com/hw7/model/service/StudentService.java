package com.hw7.model.service;

import com.hw7.model.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findById(int id);

    void save(Student student);

    void delete(int id);

}
