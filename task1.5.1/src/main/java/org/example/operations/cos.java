package org.example.operations;

import org.example.Operations;

public class cos implements Operations {
    private Double num1;
    public cos(Double a1){
        this.num1 = a1;
    }
    public Double count() {
        return Math.cos(num1);
    }
}
