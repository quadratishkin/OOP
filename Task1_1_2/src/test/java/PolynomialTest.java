import org.example.Polynomial;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PolynomialTest {

    @Test
    public void plusTest()
    {
        int[] a1 = {3, 1, 5, 0, 4, 6};
        int[] a2 = {-1, 2, 3,4, 7};

        var pol1 = new Polynomial(a1);
        var pol2 = new Polynomial(a2);

        pol1 = pol1.plus(pol2);

        int[] expected = {2, 3, 8, 4, 11, 6};
        assertArrayEquals(pol1.getCoefficients(), expected);
    }

    @Test
    public void minusTest()
    {
        int[] a1 = {6, 3, 8, 8, -2};
        int[] a2 = {1, 4, 7, 0, 11};

        var pol1 = new Polynomial(a1);
        var pol2 = new Polynomial(a2);

        pol1 = pol1.minus(pol2);

        int[] expected = {5, -1, 1, 8, -13};

        assertArrayEquals(pol1.getCoefficients(), expected);
    }

    @Test
    public void timesTest()
    {
        int[] a1 = {3, 4, 5, 6, 7};
        int[] a2 = {2,3};

        var pol1 = new Polynomial(a1);
        var pol2 = new Polynomial(a2);

        pol1 = pol1.times(pol2);

        int[] expected = {6, 17, 22, 27, 32, 21};

        assertArrayEquals(pol1.getCoefficients(), expected);
    }

    @Test
    public void evaluateTest()
    {
        int[] a1 = {3, 4, 5, 6, 7};

        var pol1 = new Polynomial(a1);

        int res = pol1.evaluate(2);

        int expected = 191;

        assertEquals(res, expected);
    }

    @Test
    public void differentiateTest()
    {
        int[] a1 = {4, 3, 6, 7};

        var pol1 = new Polynomial(a1);

        pol1 = pol1.differentiate(2);

        int[] expected = {12, 42};

        assertArrayEquals(pol1.getCoefficients(), expected);

    }

    @Test
    public void toStringTest()
    {
        int[] a1 = {4, 7, 1, 0, 0, 6, 0};

        var pol1 = new Polynomial(a1);

        String result = pol1.toString();

        String expected = "6x^5 + x^2 + 7x + 4";

        assertEquals(result, expected);

    }

}