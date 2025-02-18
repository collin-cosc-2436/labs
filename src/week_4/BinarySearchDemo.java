package week_4;

import java.util.Arrays;

public class BinarySearchDemo {
    public static void main(String[] args) {
        int [] numbers = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int target = 100;
        int targetIsAtIndex = search(numbers,target);
        System.out.println("Target "+target+" is at index: "+targetIsAtIndex);
    }

    private static int search(int[] arr, int target){
        int left = 0;
        int right = arr.length -1;
        while(left<=right){
            int mid = (left+right)/2;
            System.out.println("Checking if "+ arr[mid]+ " is equal to "+target);
            if(arr[mid]==target){
                return mid;
            }else if(arr[mid]<target){
                left = mid+1;
            }else {
                right = mid -1;
            }
        }
        return -1;
    }
}
