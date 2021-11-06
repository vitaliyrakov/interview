package com.hw5;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.hw5.model.dao.StudentDao;
import com.hw5.model.entity.Student;

import java.util.Random;

@SpringBootApplication
@RequiredArgsConstructor
public class Main implements CommandLineRunner {

    private final StudentDao studentDao;
    private static final int STUDENTS_CNT = 1000;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        HibernateUtil.openCurrentSession();
//        //studentDao.deleteAll();
        for (int i = 0; i < STUDENTS_CNT; i++) {
            Student student = new Student();
            Random random = new Random();
            student.setName("Student" + random.nextInt());
            student.setMark("mark");
            studentDao.save(student);
            System.out.println(student.getName());
        }
//        HibernateUtil.closeCurrentSessionWithTransaction();
//
//        HibernateUtil.openCurrentSessionWithTransaction();
//        Student student = studentDao.findById(3695);
//        System.out.println(student);
//        studentDao.update(student);
//        HibernateUtil.closeCurrentSessionWithTransaction();
//
//        HibernateUtil.openCurrentSessionWithTransaction();
//        System.out.println(studentDao.findById(3695));
//        HibernateUtil.closeCurrentSessionWithTransaction();
//
//        HibernateUtil.openCurrentSessionWithTransaction();
//        studentDao.findAll().forEach(System.out::println);
//        HibernateUtil.openCurrentSessionWithTransaction();
    }
}