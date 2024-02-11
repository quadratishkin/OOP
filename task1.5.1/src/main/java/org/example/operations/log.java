package org.example.operations;

import org.example.Operations;

import java.util.Stack;

public class log implements Operations {
    public Double count(Stack<Double> stack) {
        return stack.push(Math.log10(stack.pop()));
    }
}
