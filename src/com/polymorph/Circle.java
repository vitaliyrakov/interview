package com.polymorph;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Circle extends Shape {
    private double r;

    @Override
    public double getArea() {
        return Math.PI * r * r;
    }
}
