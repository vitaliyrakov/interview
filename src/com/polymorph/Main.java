package com.polymorph;

public class Main {
    public static void main(String[] args) {

        Shape square = new Square(5.5);
        System.out.println(square + " area: " + square.getArea());

        Shape circle = new Circle(3.3);
        System.out.println(circle + " area: " + circle.getArea());

        Shape triangle = new Triangle(1.5, 2.1, 3.3);
        System.out.println(triangle + " area: " + triangle.getArea());

    }
}
