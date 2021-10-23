package com.polymorph;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Square extends Shape{
    private double len;

    @Override
    public double getArea() {
        return len*len;
    }
}
