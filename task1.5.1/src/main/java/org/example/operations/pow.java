package org.example.operations;

import org.example.Operations;

import java.util.Stack;

public class pow implements Operations {
    public Double count(Stack<Double> stack) {
        return stack.push(Math.pow(stack.pop(), stack.pop()));
    }
}
