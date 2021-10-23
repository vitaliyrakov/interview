package com.cars;

class Lorry extends Car {
    public Lorry(String color) {
        super(new LorryEngine(), color, "Lorry");
    }
}