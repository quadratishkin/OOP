package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class HeapSort {
    // Управляющая программа
    public void sort(int arr[])
    {
        int count = arr.length;

        // делаем кучу
        for (int i = count / 2 - 1; i >= 0; i--)
            heapify(arr, count, i);

        // Один за другим извлекаем элементы из кучи
        for (int i=count-1; i>=0; i--)
        {
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(arr, i, 0);
        }
    }

    // Процедура для преобразования в двоичную кучу поддерева с корневым узлом i, что является
// индексом в arr[]. n - размер кучи
    void heapify(int arr[], int count, int i)
    {
        int largest = i; // инициализируем наибольший элемент как корень
        int left = 2 * i + 1; // левый = 2*i + 1
        int right = 2 * i + 2; // правый = 2*i + 2

        // Если левый ребёнок больше корня
        if (left < count && arr[left] > arr[largest])
            largest = left;

        // Если правый ребёнок больше корня
        if (right < count && arr[right] > arr[largest])
            largest = right;

        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(arr, count, largest);
        }
    }

    /* Вспомогательная функция для вывода на экран массива размера n */
    static void printArray(int arr[])
    {
        int count = arr.length;
        for (int i=0; i<count; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }


    public static void main(String args[])
    {
        int arr[] = {0, -3, 8, 21, 5, 3, 7};

        HeapSort ob = new HeapSort();
        ob.sort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }
}
