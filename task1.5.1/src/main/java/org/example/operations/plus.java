package org.example.operations;

import org.example.Operations;

public class plus implements Operations {
    private Double num1;
    private Double num2;
    public plus(Double a1, Double a2){
        this.num1 = a1;
        this.num2 = a2;
    }
    public double count() {
        return num1 + num2;
    }
}
