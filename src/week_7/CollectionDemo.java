package week_7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class CollectionDemo {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            numbers.add(random.nextInt(100));
        }

        System.out.println(numbers);

        numbers.removeIf(n -> n % 2 == 0);
        System.out.println(numbers);

        numbers.sort(Collections.reverseOrder());
        System.out.println(numbers);



        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(set.add(2));
        System.out.println(set.add(null));
        System.out.println(set.add(null));

    }
}
