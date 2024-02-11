package org.example.operations;

import org.example.Operations;

import java.util.Stack;

public class sqrt implements Operations {

    public Double count(Stack<Double> stack) {
        return stack.push(Math.sqrt(stack.pop()));
    }
}
