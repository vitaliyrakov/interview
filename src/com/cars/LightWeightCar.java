package com.cars;

class LightWeightCar extends Car {
    public LightWeightCar(String color) {
        super(new LightWeightCarEngine(), color, "LightWeightCar");
    }
}