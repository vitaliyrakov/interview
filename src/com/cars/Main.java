package com.cars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Car lorry = new Lorry("red");
        Car lightWaightCar = new LightWeightCar("black");

        System.out.println(lorry);
        System.out.println(lightWaightCar);

        List<Car> cars = new ArrayList(Arrays.asList(lorry, lightWaightCar));
        cars.forEach(car -> {
            car.open();
            car.close();
            car.start();
            car.move();
            car.stop();
            car.open();
            car.close();
        });
    }
}
