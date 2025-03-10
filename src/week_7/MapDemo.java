package week_7;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    private static Map<String, Double> studentGrades = new HashMap<>();
    public static void main(String[] args) {
       //add student and grades
        studentGrades.put("Ryan",84.00);
        studentGrades.put("Bob",87.0);
        studentGrades.put("Charlie",66.99);

        Double ryan = studentGrades.put("Ryan", 85.00);

        //average of grades
        Collection<Double> values = studentGrades.values();
        double avg = 0.0;
        int counter = 0;
        for (Double value : values) {
            avg += value.doubleValue();
            counter++;
        }
        System.out.println("Avg: " + avg/counter);
    }
}
