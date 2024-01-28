import org.example.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    Calculator calc = new Calculator();

    @Test
    public void calculateTestExample(){
        Double result =  calc.calculate("sin + - 1 2 1");
        assertEquals(0.0, result);
    }
    @Test
    public void calculateTestLogAndPow(){
        Double result =  calc.calculate("log pow 1000 3 ");
        assertEquals(9.0, result);
    }
    @Test
    public void calculateTestSqrt(){
        Double result =  calc.calculate("sqrt 121");
        assertEquals(11.0, result);
    }

}
