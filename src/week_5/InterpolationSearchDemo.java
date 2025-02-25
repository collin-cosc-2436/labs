package week_5;

public class InterpolationSearchDemo {
    public static void main(String[] args) {
        int[] numbers = {2, 3, 4, 5, 6};
        int target = 5;

//        int foundIndex = search(numbers, target);
        int foundIndex = interpolationSearch(numbers, target);
        System.out.println("Target " + target + " is at index: " + foundIndex);

    }

    private static int interpolationSearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            // probing formula to find the index position where to partition
//            [𝑝𝑜𝑠=𝑙𝑜𝑤+(𝑡𝑎𝑟𝑔𝑒𝑡−𝑎𝑟𝑟[𝑙𝑜𝑤])×(ℎ𝑖𝑔ℎ−𝑙𝑜𝑤)/𝑎𝑟𝑟[ℎ𝑖𝑔ℎ]−𝑎𝑟𝑟[𝑙𝑜𝑤]]

            int pos = left + (((target - arr[left]) * (right - left)) / (arr[right] - arr[left]));
            System.out.println("Checking if " + arr[pos] + " is equal to " + target);

            if (arr[pos] == target) {
                return pos;
            }
            if (arr[pos] < target) {
                left = pos + 1;
            }
            else{
                right = pos-1;
            }

        }
        return -1;
    }

    private static int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            System.out.println("Checking if " + arr[mid] + " is equal to " + target);
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
