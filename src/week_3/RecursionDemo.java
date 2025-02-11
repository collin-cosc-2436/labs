package week_3;

public class RecursionDemo {

    public static void main(String[] args) {

        //factorial of 5. => 5!

        int number = 5;
        int result = factorial(number);
        System.out.println("Factorial of " + number + " is: " + result);

        int result2 = recursionFactorial(5);
        System.out.println("Factorial of " + number + " is: " + result2);

    }


    private static int factorial(int number) {
        //iterative
//        int result = 1; //accumulator
//        for (int i = 1; i <= number; i++) {
//            result = result * i;
//        }
//        return result;


        int result = 1;
        int i = 1;
        //iterative while
        while (i <= number) {
            result *= i;
            i++;
        }
        return result;


    }

    private static int recursionFactorial(int number) {
        //base case
//        if (number == 1) {
//            return 1;
//        } else {
//            return number * recursionFactorial(number - 1);
//        }

//        if(number>1){
//            return number * recursionFactorial(number - 1);
//        }else{
//            return 1;
//        }


        //ternary operations
        return number > 1 ? number * recursionFactorial(number - 1) : 1;
    }

}
