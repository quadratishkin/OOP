package org.example.operations;

import org.example.Operations;

import java.util.Stack;


public class devide implements Operations{
    public Double count(Stack<Double> stack) {
        Double a1 = stack.pop();
        Double a2 = stack.pop();
        if(a2 == 0){
            throw new RuntimeException("Деление на 0");
        }
        return stack.push(a1 / a2);
        }
    }
