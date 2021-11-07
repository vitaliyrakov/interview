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

        Student student;

        HibernateUtil.openSession();
        //studentDao.deleteAll();
        for (int i = 1; i <= STUDENTS_CNT; i++) {
            student = new Student();
            Random random = new Random();
            student.setName("Student" + random.nextInt());
            student.setMark("mark");
            student.setId(i);
            studentDao.save(student);
        }
        HibernateUtil.closeSession();

        int testID = 1111;
        HibernateUtil.openSession();
        student = studentDao.findById(testID);
        System.out.println(student);
        student.setName(student.getName() + "_new");
        studentDao.update(student);
        student = studentDao.findById(testID);
        System.out.println(student);
        HibernateUtil.closeSession();

        HibernateUtil.openSession();
        student = studentDao.findById(testID);
        studentDao.delete(student);
        System.out.println(studentDao.findById(testID));
        HibernateUtil.closeSession();

        HibernateUtil.openSession();
        studentDao.findAll().forEach(System.out::println);
        HibernateUtil.closeSession();
    }
}