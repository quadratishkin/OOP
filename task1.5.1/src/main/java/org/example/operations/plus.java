package org.example.operations;

import org.example.Operations;

import java.util.Stack;

public class plus implements Operations {
    public Double count(Stack<Double> stack) {
        return stack.push(stack.pop() + stack.pop());
    }
}
