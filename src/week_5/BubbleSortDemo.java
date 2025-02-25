package week_5;

import java.util.Arrays;

public class BubbleSortDemo {
    public static void main(String[] args) {
//        int[] numbers = generateIntArray(10);
        int[] numbers = {1,2,3,4,5};
        System.out.println("Before Array: " + Arrays.toString(numbers));

        bubbleSort(numbers);

        System.out.println("Sorted Array: " + Arrays.toString(numbers));
    }

    //Array generator
    public static int[] generateIntArray(int size){
        int[] numbers = new int[size];
        for (int i = 0; i<numbers.length; i++){
            numbers[i] = (int)(Math.random()*10000);
        }
        return numbers;
    }

    private static void bubbleSort(int[] arr) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                System.out.println("comparing....");
                if(arr[j]>arr[j+1]){
                    //swap
                    int temp = arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(swapped==false){
                break;
            }
        }
        System.out.println("Total Time: "+(System.currentTimeMillis()-start));
    }
}
