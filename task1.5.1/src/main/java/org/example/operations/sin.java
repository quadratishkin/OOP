package org.example.operations;

import org.example.Operations;

public class sin implements Operations {
    private Double num1;
    public sin(Double a1){
        this.num1 = a1;
    }
    public Double count() {
        return Math.sin(num1);
    }
}
