package week_3;

/*
    Tail recursion is generally more efficient because it can be optimized
    to iterative loops by the compiler, reducing the risk of stack overflow and improving performance.
    This version is tail-recursive because the recursive call is the last operation in the function.
 */
public class TailRecursionDemo {
    public static void main(String[] args) {
        int number = 5;
        int fac = factorial(number);
        System.out.println("Factorial of " + number + " is " + fac);
    }

    private static int factorial(int number) {
        return factorial(number, 1);
    }

    private static int factorial(int number, int result) {
        if (number == 0) {
            return result;
        } else {
            return factorial(number - 1, number * result);
        }
    }
}
