package com.person;

public class Main {

    public static void main(String[] args) {

        Person person1 = Person.builder().firstName("Ivan").build();
        System.out.println(person1);

        Person person2 = Person.builder()
                .firstName("Viktor")
                .lastName("Popov")
                .gender("Male")
                .age(30)
                .country("Russia")
                .phone("9112263538")
                .build();

        System.out.println(person2);
    }
}