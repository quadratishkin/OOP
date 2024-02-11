package org.example.operations;

import org.example.Operations;

import java.util.Stack;

public class log implements Operations {

    public Double count(Stack<Double> stack) {

        Double a1 = stack.pop();
        if (a1<=0){
            throw new RuntimeException("Подлогарифмическое выражение длолжно быть больше 0");
        }
        return stack.push(Math.log10(a1));
    }
}
