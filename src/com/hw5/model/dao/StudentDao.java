package com.hw5.model.dao;

import org.springframework.stereotype.Repository;
import com.hw5.model.entity.Student;

@Repository
public class StudentDao extends DaoImpl<Student> {
    {
        setClassStudent(Student.class);
    }
}
