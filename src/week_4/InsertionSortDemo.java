package week_4;

import java.util.Arrays;

public class InsertionSortDemo {
    public static void main(String[] args) {
        int[] numbers = {5, 4, 8, 3, 2};   //generateIntArray(10);
        System.out.println("Before Array: " + Arrays.toString(numbers));

        insertionSort(numbers);

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

    public static void insertionSort(int[] arr) {
        //{5, 4, 8, 3, 2}
        //{5, 5, 8, 3, 2}
        //{4, 5, 8, 3, 2}

        //{4, 5, 8, 8, 2}
        //{4, 5, 5, 8, 2}
        //{4, 4, 5, 8, 2}
        //{3, 4, 5, 8, 2}
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i]; //the element that we want to insert in correct position.
            int j = i - 1; //start comparing with the previous elements.
            while (j >= 0 && arr[j] > key) {
                //shift elements to the right
                arr[j + 1] = arr[j];
                j = j - 1; //moving one step back.
            }
            //insert the key
            arr[j + 1] = key;

        }


    }
}
