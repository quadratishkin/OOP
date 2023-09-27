package org.example;
import java.util.Arrays;

public class Main {
    public static void main(String args[])
    {
        int arr[] = {82, 24, 234, 22, 1, 2};

        HeapSort.sort(arr);

        System.out.println("Sorted array is");
        System.out.println(Arrays.toString(arr));
    }
}