package week_5;

import java.util.Arrays;

public class HeapSortDemo {
    public static void main(String[] args) {
        int[] numbers = {38, 27, 43, 3, 9, 32, 10};
        System.out.println("Original Array: " + Arrays.toString(numbers));
        heapSort(numbers);
        System.out.println("After Sorting: " + Arrays.toString(numbers));
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;
        //Step 1: build the max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        //step: 2
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i); //moving the current root(max) to end
            heapify(arr, i, 0); // Heapifying the remaining heap.
        }

    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i;//Assuming node is largest
        int leftChildIndex = 2 * i + 1;
        int rightChildIndex = 2 * i + 2;

        if (leftChildIndex < n && arr[leftChildIndex] > arr[largest]) {
            largest = leftChildIndex;
        }
        if (rightChildIndex < n && arr[rightChildIndex] > arr[largest]) {
            largest = rightChildIndex;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
