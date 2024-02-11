package org.example;
import java.util.Stack;

public class Calculator {
    public String[] operations = new String[] {"+", "-", "*", "/", "log", "pow", "sqrt", "sin", "cos"};
    public Double calculate(String expression) {
        String[] expr = expression.split(" ");
        Stack<Double> myStack = new Stack<>();
        for (int i = expr.length - 1; i >= 0; i--) {
            try{
                Double tmp = Double.parseDouble(expr[i]);
                myStack.push(tmp);
            }
            catch (NumberFormatException e) {
                OperationFactory operationFactory = new OperationFactory();
                operationFactory.whatIsOperation(expr[i]).count(myStack);
            }
        }
        return myStack.pop();
    }
}
