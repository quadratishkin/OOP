import org.example.Polynoms;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PolynomsTest {
    @Test
    public void plusTest() {
        Polynoms p1 = new Polynoms(new int[]{8, 1, 6, 7});
        Polynoms p2 = new Polynoms(new int[]{1, 4, 8});
        Polynoms p3 = new Polynoms(new double[]{9.0, 5.0, 14.0, 7.0});
        assertEquals(p1.plus(p2), p3);
    }

    @Test
    public void minusTest() {
        Polynoms p1 = new Polynoms(new double[]{4, 3, 6, 7});
        Polynoms p2 = new Polynoms(new int[]{3, 2, 8});
        Polynoms p3 = new Polynoms(new double[]{1.0, 1.0, -2.0, 7.0});
        assertEquals(p1.minus(p2), p3);
    }

    @Test
    public void minusZeroTest() {
        Polynoms p1 = new Polynoms(new double[]{1, 2, 3, 4});
        Polynoms p2 = new Polynoms(new double[]{1, 2, 3, 4});
        assertEquals("0", p1.minus(p2).toString());
    }

    @Test
    public void minusInnerZeroTest() {
        Polynoms p1 = new Polynoms(new double[]{3, 9, 6, 7});
        Polynoms p2 = new Polynoms(new double[]{2, 9, 6, 6});
        Polynoms p3 = new Polynoms(new double[]{1.0, 0.0, 0.0, 1.0});
        assertEquals(p1.minus(p2), p3);
    }

    @Test
    public void timesTest() {
        Polynoms p1 = new Polynoms(new int[]{4, 3, 6, 7});
        Polynoms p2 = new Polynoms(new int[]{3, 2, 8});
        Polynoms p3 = new Polynoms(new double[]{12.0, 17.0, 56.0, 57.0, 62.0, 56.0});
        assertEquals(p1.times(p2), p3);
    }

    @Test
    public void differentiateTest() {
        Polynoms p1 = new Polynoms(new int[]{4, 3, 6, 7});
        Polynoms p2 = new Polynoms(new double[]{3.0, 12.0, 21.0});
        assertEquals(p1.differentiate(1), p2);
    }

    @Test
    public void evaluateTest() {
        Polynoms p1 = new Polynoms(new int[]{4, 3, 6, 7});
        assertEquals(90, p1.evaluate(2));
    }

    @Test
    public void equalityTrueTest() {
        Polynoms p1 = new Polynoms(new int[]{1, 4, 0, 6});
        Polynoms p2 = new Polynoms(new int[]{1, 4, 0, 6});
        assertEquals(p1, p2);
    }

    @Test
    public void equalityFalseTest() {
        Polynoms p1 = new Polynoms(new int[]{7, 3, 4, 1});
        Polynoms p2 = new Polynoms(new int[]{5, 2, 4, 2});
        assertNotEquals(p1, p2);
    }
}