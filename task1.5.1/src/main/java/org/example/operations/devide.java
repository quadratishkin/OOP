package org.example.operations;

import org.example.Operations;


public class devide implements Operations{
    private Double num1;
    private Double num2;
    public devide(Double a1, Double a2){
        this.num1 = a1;
        this.num2 = a2;
    }
    public Double count() {
        return num1 / num2;
    }
}
