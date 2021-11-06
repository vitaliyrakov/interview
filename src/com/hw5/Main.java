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
        for (int i = 1; i <= STUDENTS_CNT; i++) {
            Student student = new Student();
            Random random = new Random();
            student.setName("Student" + random.nextInt());
            student.setMark("mark");
            student.setId(i);
            studentDao.save(student);
            System.out.println(student.getName());
        }
        HibernateUtil.closeCurrentSession();

        HibernateUtil.openCurrentSession();
        Student student = studentDao.findById(100);
        System.out.println(student);
        student.setName(student.getName()+"_new");
        studentDao.update(student);
        student = studentDao.findById(100);
        System.out.println(student);
        HibernateUtil.closeCurrentSession();

        HibernateUtil.openCurrentSession();
        student = studentDao.findById(100);
        studentDao.delete(student);
        student = studentDao.findById(100);
        System.out.println(student);
        HibernateUtil.closeCurrentSession();

        HibernateUtil.openCurrentSession();
        studentDao.findAll().forEach(System.out::println);
        HibernateUtil.closeCurrentSession();
    }
}