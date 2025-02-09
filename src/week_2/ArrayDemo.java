package week_2;

import java.util.Arrays;

public class ArrayDemo {

    public static void main(String[] args) {
        int[] numbers = {20,30,10,40};
        System.out.println("First element "+numbers[0]);
        System.out.println("Length "+ numbers.length);

//        System.out.println(numbers[4]); // java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 4

        //searching, return index of target
        int target = 10;
        int idx = search(numbers, target);
        System.out.println("index of "+target+" is "+ idx);

        Arrays.sort(numbers);
        System.out.println("sorted Array: "+ Arrays.toString(numbers));

    }

    public static int search(int[] arr, int target){
        for (int i=0;i<arr.length;i++){
            if(arr[i]==target){
                return i;
            }
        }
        return -1;
    }



}
