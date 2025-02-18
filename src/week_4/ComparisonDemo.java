package week_4;

import java.util.Arrays;
import java.util.Collections;

public class ComparisonDemo {

    public static void main(String[] args) {

        Student s1 = new Student("Alice", 23);
        Student s2 = new Student("Bret", 23);
//        Student s3 = s1;
//        System.out.println(s1 == s2); //false
//        System.out.println(s1 == s3); //true

//        System.out.println(s1.equals(s2)); //false

        Student[] students = {s1, s2, new Student("Nancy", 12), new Student("Alan", 17), new Student("Mike", 22)};

        printStudent(students);
//        Arrays.sort(students);
        Arrays.sort(students,new NameComparator());
        System.out.println("------");
        printStudent(students);
    }

    private static void printStudent(Student[] students) {
        for (Student s : students){
            System.out.println("["+s.name+", "+s.age+"]");
        }
    }
}
