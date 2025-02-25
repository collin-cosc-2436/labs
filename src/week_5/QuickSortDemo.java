package week_5;

import java.util.Arrays;

public class QuickSortDemo {

    public static void main(String[] args) {
        int[] numbers = {38, 27, 43, 3, 9, 32, 10};
        System.out.println("Original Array: " + Arrays.toString(numbers));
        quickSort(numbers, 0, numbers.length - 1);
        System.out.println("After Sorting: " + Arrays.toString(numbers));
    }

    public static void quickSort(int[] arr, int left, int right) {
        //base case:

        if (left < right) {
            int pivotIndex = partition(arr, left, right);

            //Recursively sort element before and after partition
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right]; // Choosing the last element but we can also choose first or random
        int i = left - 1;//pointer for smaller element;

        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) { //fi element is smaller than pivot
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right); //Placing pivot int the correct position.
        return i + 1;
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}


/**
 * arr = [38, 27, 43, 3, 9, 32, 10]
 * step: 1 initial call:
 * left = 0; right = 6, pivot=10
 * partitioning the array:
 * Elements less than 10 ==> [3,9]
 * Elements greater than 10 ==> [38,27,43,32]
 * new position for pivot 10 ==> 2
 *
 * step 2: [3,9,10,38,27,32,43]
 * mergeSort([3,9])
 * mergeSort([10,38,27,32,43])
 *
 */