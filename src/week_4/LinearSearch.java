package week_4;

public class LinearSearch {
    public static void main(String[] args) {
        int [] numbers = {60, 20, 80, 100, 50, 10, 70, 30, 90, 40};
        int target = 50;
        int targetIsAtIndex = search(numbers,target);
        System.out.println("Target "+target+" is at index: "+targetIsAtIndex);
    }

    private static int search(int[] arr, int target){
        for (int i=0; i<arr.length;i++ ){

            if(arr[i]==target){ // n
                return i;
            }
        }
        return -1;
    }
}

//Algorithm Analysis.
/*
int i=0 ==> 1
i<arr.length ==> n
i++ ==> n-1
if(arr[i]==target) ==> n-1
return i; ==> 1
return -1; ==> 1

Total Operations: 1+n+n-1+n-1+1+1 => 3n+1
n=10 = 3n+1 ==> 31
n=1000 = 3001

when n--> INF ,  3x and + 1


Time Complexity of this linear algorithm: O(n)

int target ==> 1
int i=0==> 1
1+1 == 2 ==> Constant.
Space Complexity of this linear algo: O(1)


 */
