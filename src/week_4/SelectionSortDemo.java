package week_4;

import java.util.Arrays;

public class SelectionSortDemo {
    public static void main(String[] args) {
        int[] numbers = generateIntArray(10);
        System.out.println("Before Array: " + Arrays.toString(numbers));

        selectionSort(numbers);

        System.out.println("Sorted Array: " + Arrays.toString(numbers));
    }

    //Array generator
    public static int[] generateIntArray(int size) {
        int[] numbers = new int[size];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 10000);
        }
        return numbers;
    }

    public static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            //assume the current element is the smallest
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[j] < arr[min]) {
                    //update our min value
                    min = j;
                }
            }
            //min will be smallest
            //swap
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }


    }
}
