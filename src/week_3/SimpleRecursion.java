package week_3;

public class SimpleRecursion {

    public static void main(String[] args) {
        int number = 5;
        System.out.println("Sum of 1 to " + number + " is :" + sum(number));
    }

    //n+(n-1)+(n-2)+.......+1
    static int sum(int n) {
        //base case
        if (n == 1) {
            return 1;
        }
        return n + sum(n - 1);
    }

    /*
    call 1: sum(5) = 5 + sum(4) = 5+10 =15
    call 2: sum(4) = 4 + sum(3) = 4+6=10
    call 3: sum(3) = 3 + sum(2) = 3+3 = 6
    call 4: sum(2) = 2 + sum(1) = 2+1=3
    call 5: sum(1) = 1



     */


}
