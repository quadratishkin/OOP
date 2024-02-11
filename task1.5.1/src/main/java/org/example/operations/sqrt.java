package org.example.operations;

import org.example.Operations;

import java.util.Stack;

public class sqrt implements Operations {


    public Double count(Stack<Double> stack) {
        Double a1 = stack.pop();
        if (a1 < 0){
            throw new RuntimeException("подлогарифмическое выражение отриацательное");
        }
        return stack.push(Math.sqrt(a1));
    }
}
