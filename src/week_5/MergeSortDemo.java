package week_5;

import java.util.Arrays;

public class MergeSortDemo {

    public static void main(String[] args) {
        int[] numbers = {38, 27, 43, 9, 32, 10};
        System.out.println("Original Array: " + Arrays.toString(numbers));
        mergeSort(numbers, 0, numbers.length - 1);
        System.out.println("After Sorting: " + Arrays.toString(numbers));
    }

    private static void mergeSort(int[] numbers, int left, int right) {
        //base case
        if (left < right) {
            int mid = (left + right) / 2;

            //recursively sort the left half
            mergeSort(numbers, left, mid);

            //recursively sort the right half
            mergeSort(numbers, mid + 1, right);

            //Merge the two sorted Halves.
            merge(numbers, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        //Sizes of two arrays.
        int n1 = mid - left + 1;
        int n2 = right - mid;

        //create temp array of these size
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        //Copy data to these temp arrays:
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        //copy the right array
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }


        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        //copy remaining elements of leftArray
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        //copy remaining elements of leftArray
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }


    }


}
