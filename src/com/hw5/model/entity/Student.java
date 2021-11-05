package com.hw5.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "student")
@Data
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "mark")
    private String mark;

}
