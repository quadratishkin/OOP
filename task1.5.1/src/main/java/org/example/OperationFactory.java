package org.example;

import org.example.operations.*;


public class OperationFactory {

    public static Operations whatIsOperation(String str){
        switch (str){
            case ("+"):
                return new plus();
            case ("-"):
                return new minus();
            case ("*"):
                return new mul();
            case ("/"):
                return new devide();
            case ("log"):
                return new log();
            case ("pow"):
                return new pow();
            case ("sqrt"):
                return new sqrt();
            case("sin"):
                return new sin();
            case("cos"):
                return new cos();
        }
        return null;
    }
}
