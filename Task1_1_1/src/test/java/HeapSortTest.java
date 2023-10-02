import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.example.HeapSort;

import java.util.Arrays;
import java.util.Random;

public class HeapSortTest {

    @Test
    public void testHeapSort() {
        int[] arr = {12, 11, 13, 5, 6, 7};
        int[] expected = {5, 6, 7, 11, 12, 13};

        HeapSort.sort(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    public void testEmptyArray() {
        int[] arr = {};
        int[] expected = {};

        HeapSort.sort(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    public void testArrayWithDuplicates() {
        int[] arr = {5, 4, 3, -6, 5};
        int[] expected = {-6, 3, 4, 5, 5};

        HeapSort.sort(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    public void testBigMassive() {
        int[] arr = new int[100000];
        Random numbers = new Random();
        for (int i = 0; i < 100000; i++)
        {
            int n = numbers.nextInt(2000000);
            arr[i] = n;
        }

        int[] expected = Arrays.copyOf(arr, 100000);

        HeapSort.sort(arr);
        Arrays.sort(expected);
        assertArrayEquals(expected, arr);
    }

}