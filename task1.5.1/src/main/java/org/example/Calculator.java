package org.example;

import javax.management.RuntimeErrorException;
import java.util.Stack;

public class Calculator {
    public String[] operations = new String[] {"+", "-", "*", "/", "log", "pow", "sqrt", "sin", "cos"};
    public double calculate(String expression) {
        String[] expr = expression.split(" ");
        Stack<Double> myStack = new Stack<>();
        Double a1;
        Double a2;
        for (int i = expr.length - 1; i >= 0; i--) {
            try{
                Double tmp = Double.parseDouble(expr[i]);
                myStack.push(tmp);
            }
            catch (NumberFormatException e) {
                switch (expr[i]) {
                    case ("+"):
                        a1 = myStack.pop();
                        a2 = myStack.pop();
                        myStack.push(a1 + a2);
                        break;
                    case ("-"):
                        a1 = myStack.pop();
                        a2 = myStack.pop();
                        myStack.push(a1 - a2);
                        break;
                    case ("*"):
                        a1 = myStack.pop();
                        a2 = myStack.pop();
                        myStack.push(a1 * a2);
                        break;
                    case ("/"):
                        a1 = myStack.pop();
                        a2 = myStack.pop();
                        if(a2 == 0){
                            throw new RuntimeException("деление на 0");
                        }
                        myStack.push(a1 / a2);
                        break;
                    case ("log"):
                        a1 = myStack.pop();
                        if(a1 < 0){
                            throw new RuntimeException("подлогарифмическое выражение отриацательное");
                        }
                        if (a1 <= 0) {
                            return 0;
                        }
                        myStack.push(Math.log10(a1));
                        break;
                    case ("pow"):
                        a1 = myStack.pop();
                        a2 = myStack.pop();
                        myStack.push(Math.pow(a1, a2));
                        break;
                    case ("sqrt"):
                        a1 = myStack.pop();
                        if(a1 < 0){
                            throw new RuntimeException("отрицательное значние под корнем");
                        }
                        if (a1 < 0) {
                            return 0;
                        }
                        myStack.push(Math.sqrt(a1));
                        break;
                    case("sin"):
                        a1 = myStack.pop();
                        myStack.push(Math.sin(a1));
                        break;
                    case("cos"):
                        a1 = myStack.pop();
                        myStack.push(Math.cos(a1));
                        break;

                }
            }
        }
        return myStack.pop();
    }
}
