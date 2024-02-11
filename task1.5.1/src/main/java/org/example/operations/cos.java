package org.example.operations;

import org.example.Operations;

import java.util.Stack;

public class cos implements Operations {
    public Double count(Stack<Double> stack) {
        return stack.push(Math.cos(stack.pop()));
    }
}
