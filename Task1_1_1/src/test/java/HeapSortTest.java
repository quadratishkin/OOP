import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.example.HeapSort;

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

}