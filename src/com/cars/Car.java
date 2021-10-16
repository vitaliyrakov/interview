package com.cars;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
abstract class Car implements Moveable, Openable {
    private Engine engine;
    private String color;
    private String name;

    @Override
    public void start() {
        System.out.println("Car " + name + " starting");
    }

    @Override
    public void move() {
        System.out.println("Car " + name + " is moving");
    }

    @Override
    public void stop() {
        System.out.println("Car " + name + " is stop");
    }

    @Override
    public void open() {
        System.out.println("Car " + name + " is open");
    }

    @Override
    public void close() {
        System.out.println("Car " + name + " is close");
    }

}