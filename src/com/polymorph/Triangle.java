package com.polymorph;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Triangle extends Shape{
    private double x;
    private double y;
    private double z;

    @Override
    public double getArea() {
        double p = (x+y+z)/2;
        return Math.sqrt(p * (p - x) * (p - y) * (p - z));
    }
}
