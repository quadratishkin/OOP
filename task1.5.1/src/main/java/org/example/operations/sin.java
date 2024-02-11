package org.example.operations;

import org.example.Operations;

import java.util.Stack;

public class sin implements Operations {
    public Double count(Stack<Double> stack) {
        return stack.push(Math.sin(stack.pop()));
    }
}
