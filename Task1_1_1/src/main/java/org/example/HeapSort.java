package org.example;

public class HeapSort {
    public static void sort(int[] arr) {
        int count = arr.length;

        for (int i = count / 2 - 1; i >= 0; i--) {
            heapify(arr, count, i);
        }

        for (int i = count - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int count, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < count && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < count && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int tmp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = tmp;

            heapify(arr, count, largest);
        }
    }
}