package week_3;

import java.util.Arrays;

public class FibonacciDemo {
    public static void main(String[] args) {

        int n = 5;
        System.out.println("Fibonacci of " + 5 + " is :" + fibonacci(n));

        int[] store = new int[n + 1];
        System.out.println("Fibonacci of " + 5 + " is using memoization:" + memoizationFib(n, store));
        System.out.println("Store values: " + Arrays.toString(store));


//        int[] array = {1, 2, 3} // 4, 5, 6, 7, 8};
//
//        int target = 2; //index 1;
//        //target = 6; //index: 5

    }

    //    naive recursion
    private static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    //memoizationFib
    static int memoizationFib(int n, int[] store) {
        if (n <= 1) {
            return n;
        }
        if (store[n] != 0) {
            return store[n]; //return cached
        }

        store[n] = memoizationFib(n - 2, store) + memoizationFib(n - 1, store);
        return store[n];
    }



    /*
    call 1: fib(5) = fib(4) + fib(3)
    call 2: fib(4) = fib(3) + fib(2)
            fib(3) = fib(2) + fib(1)
            fib(2) = fib(1) + fib(0)
            fib(1) = 1
            fib(0) = 0
     */


}
