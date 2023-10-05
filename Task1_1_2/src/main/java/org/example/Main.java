package org.example;

public class Main {
    public static void main(String[] args) {
        Polynoms num1 = new Polynoms(new double[] {0.9});
        Polynoms num2 = new Polynoms(new double[] {0.3});

        System.out.println(num1.plus(num2.differentiate(1)).toString());
        System.out.println(num1.times(num2).evaluate(2));
        System.out.println(num1.times(num2));
    }
}