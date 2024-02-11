package org.example.operations;

import org.example.Operations;

public class log implements Operations {
    private Double num1;
    public log(Double a1){
        this.num1 = a1;
    }
    public Double count() {
        return Math.log10(num1);
    }
}
