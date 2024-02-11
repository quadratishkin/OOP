package org.example.operations;

import org.example.Operations;

public class sqrt implements Operations {
    private Double num1;
    public sqrt(Double a1){
        this.num1 = a1;
    }
    public double count() {
        return Math.sqrt(num1);
    }
}
