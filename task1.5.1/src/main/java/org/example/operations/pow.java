package org.example.operations;

import org.example.Operations;

public class pow implements Operations {
    private Double num1;
    private Double num2;
    public pow(Double a1, Double a2){
        this.num1 = a1;
        this.num2 = a2;
    }
    public Double count() {
        return Math.pow(num1, num2);
    }
}
