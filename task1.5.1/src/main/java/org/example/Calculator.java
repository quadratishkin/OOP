package org.example;

import org.example.operations.*;

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
                        plus plus = new plus(a1, a2);
                        myStack.push(plus.count());
                        break;
                    case ("-"):
                        a1 = myStack.pop();
                        a2 = myStack.pop();
                        minus minus = new minus(a1, a2);
                        myStack.push(minus.count());
                        break;
                    case ("*"):
                        a1 = myStack.pop();
                        a2 = myStack.pop();
                        mul mul = new mul(a1, a2);
                        myStack.push(mul.count());
                        break;
                    case ("/"):
                        a1 = myStack.pop();
                        a2 = myStack.pop();
                        if(a2 == 0){
                            throw new RuntimeException("деление на 0");
                        }
                        devide devide = new devide(a1,a2);
                        myStack.push(devide.count());
                        break;
                    case ("log"):
                        a1 = myStack.pop();
                        if(a1 < 0){
                            throw new RuntimeException("подлогарифмическое выражение отриацательное");
                        }
                        log log = new log(a1);
                        myStack.push(log.count());
                        break;
                    case ("pow"):
                        a1 = myStack.pop();
                        a2 = myStack.pop();
                        pow pow = new pow(a1, a2);
                        myStack.push(pow.count());
                        break;
                    case ("sqrt"):
                        a1 = myStack.pop();
                        if(a1 < 0){
                            throw new RuntimeException("отрицательное значние под корнем");
                        }
                        sqrt sqrt = new sqrt(a1);
                        myStack.push(sqrt.count());
                        break;
                    case("sin"):
                        a1 = myStack.pop();
                        sin sin = new sin(a1);
                        myStack.push(sin.count());
                        break;
                    case("cos"):
                        a1 = myStack.pop();
                        cos cos = new cos(a1);
                        myStack.push(cos.count());
                        break;
                }
            }
        }
        return myStack.pop();
    }
}
