package week_7;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPIDemo {



    public static void main(String[] args) {
        System.out.println("========== INTRODUCTION TO STREAMS ==========");
        basicStreamExample();

        System.out.println("\n========== CREATING STREAMS ==========");
        creatingStreamsExamples();

        // Create sample data
        List<Student> students = Arrays.asList(
                new Student("Alice", 85, "Computer Science", Arrays.asList("Java", "Algorithms", "Database")),
                new Student("Bob", 72, "Mathematics", Arrays.asList("Calculus", "Statistics", "Algebra")),
                new Student("Charlie", 90, "Computer Science", Arrays.asList("Python", "Algorithms", "AI")),
                new Student("David", 65, "Mathematics", Arrays.asList("Geometry", "Algebra", "Statistics")),
                new Student("Eve", 95, "Computer Science", Arrays.asList("Java", "Data Structures", "Networking")),
                new Student("Frank", 78, "Physics", Arrays.asList("Mechanics", "Electromagnetism", "Optics")),
                new Student("Grace", 88, "Computer Science", Arrays.asList("Java", "Web Development", "Cloud Computing"))
        );


        System.out.println("\n========== INTERMEDIATE OPERATIONS ==========");
        intermediateOperationsExamples(students);

        System.out.println("\n========== TERMINAL OPERATIONS ==========");
        terminalOperationsExamples(students);

        System.out.println("\n==========  PIPELINE PROCESSING DEMONSTRATION ==========");
        pipelineProcessingDemo(students);

        System.out.println("\n==========  LAZY EVALUATION DEMONSTRATION ==========");
        lazyEvaluationDemo();

        System.out.println("\n==========  PARALLELISM ==========");
        parallelismDemo();

    }

    private static void basicStreamExample() {

        // Traditional approach
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenSquares = new ArrayList<>();

        System.out.println("Using traditional loop:");
        for (Integer num : numbers) {
            if (num % 2 == 0) {
                evenSquares.add(num * num);
            }
        }
        System.out.println(evenSquares);

        // Stream approach
        System.out.println("Using Stream API:");
        List<Integer> streamEvenSquares = numbers.stream()
                .filter(n -> n % 2 == 0)     // Keep only even numbers
                .map(n -> n * n)             // Square each number
                .collect(Collectors.toList()); // Collect into a list
        System.out.println(streamEvenSquares);
    }

    private static void creatingStreamsExamples() {

        // 1. From a collection
        Collection<String> collection = Arrays.asList("Java", "Stream", "API");
        Stream<String> streamFromCollection = collection.stream();
        System.out.println("From Collection: " + streamFromCollection.collect(Collectors.joining(", ")));

        // 2. From an array
        String[] array = {"a", "b", "c"};
        Stream<String> streamFromArray = Arrays.stream(array);
        System.out.println("From Array: " + streamFromArray.collect(Collectors.joining(", ")));

        // 3. Using Stream.of
        Stream<Integer> streamOf = Stream.of(1, 2, 3, 4, 5);
        System.out.println("Using Stream.of: " + streamOf.collect(Collectors.toList()));

        // 4. Using Stream.iterate (infinite stream with limit)
        Stream<Integer> iterateStream = Stream.iterate(0, n -> n + 2).limit(5);
        System.out.println("Using iterate: " + iterateStream.collect(Collectors.toList()));

        // 5. Using Stream.generate (infinite stream with limit)
        Stream<Double> generateStream = Stream.generate(Math::random).limit(3);
        System.out.println("Using generate: " + generateStream.map(n -> String.format("%.4f", n)).toList());

    }

    private static void intermediateOperationsExamples(List<Student> students) {

        // 1. filter - Get students with grade above 80
        System.out.println("\n1. filter - Students with grade above 80:");
        students.stream()
                .filter(student -> student.getGrade() > 80)
                .forEach(System.out::println);

        // 2. map - Get all student names
        System.out.println("\n2. map - Get all student names:");
        List<String> studentNames = students.stream()
                .map(Student::getName)
                .collect(Collectors.toList());
        System.out.println(studentNames);

        // 3. flatMap - Get all courses taken by students
        System.out.println("\n3. flatMap - All courses taken by students:");
        List<String> allCourses = students.stream()
                .flatMap(student -> student.getCourses().stream())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(allCourses);

        // 4. sorted - Sort students by grade
        System.out.println("\n4. sorted - Students sorted by grade:");
        students.stream()
                .sorted(Comparator.comparing(Student::getGrade))
                .forEach(System.out::println);

        // 5. distinct - Unique departments
        System.out.println("\n5. distinct - Unique departments:");
        List<String> departments = students.stream()
                .map(Student::getDepartment)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(departments);

        // 6. limit - First 3 students
        System.out.println("\n6. limit - First 3 students:");
        students.stream()
                .limit(3)
                .forEach(System.out::println);

        // 7. skip - Skip first 2 students
        System.out.println("\n7. skip - Skip first 2 students:");
        students.stream()
                .skip(2)
                .forEach(System.out::println);

        // 8. peek - Debug/inspect elements without modifying stream
        System.out.println("\n8. peek - Debugging stream processing:");
        List<String> csStudents = students.stream()
                .filter(s -> s.getDepartment().equals("Computer Science"))
                .peek(s -> System.out.println("Filtered: " + s.getName()))
                .map(Student::getName)
                .peek(name -> System.out.println("Mapped: " + name))
                .collect(Collectors.toList());
        System.out.println("CS Students: " + csStudents);
    }

    private static void terminalOperationsExamples(List<Student> students) {

        // 1. forEach - Print all students
        System.out.println("\n1. forEach - Print all students:");
        students.stream().forEach(System.out::println);

        // 2. collect - Collect into various collections
        System.out.println("\n2. collect - Collect students by department:");
        Map<String, List<Student>> studentsByDept = students.stream()
                .collect(Collectors.groupingBy(Student::getDepartment));
        studentsByDept.forEach((dept, stds) -> {
            System.out.println(dept + ":");
            stds.forEach(s -> System.out.println("  " + s.getName()));
        });

        // 3. reduce - Calculate total grade of all students
        System.out.println("\n3. reduce - Total of all student grades:");
        int totalGrade = students.stream()
                .map(Student::getGrade)
                .reduce(0, Integer::sum);
        System.out.println("Total grade: " + totalGrade);

        // 4. count - Count students by department
        System.out.println("\n5. count - Number of CS students:");
        long csStudentCount = students.stream()
                .filter(s -> s.getDepartment().equals("Computer Science"))
                .count();
        System.out.println("Number of CS students: " + csStudentCount);

        // 5. findFirst, findAny
        System.out.println("\n7. findFirst and findAny:");
        Student firstCSStudent = students.stream()
                .filter(s -> s.getDepartment().equals("Computer Science"))
                .findFirst()
                .orElse(null);
        System.out.println("First CS student: " + firstCSStudent);
    }

    private static void pipelineProcessingDemo(List<Student> students) {


        double averageGrade = students.stream()
                // First stage: filter CS students
                .filter(s -> s.getDepartment().equals("Computer Science"))
                // Print intermediate results to see pipeline in action
                .peek(s -> System.out.println("After first filter: " + s.getName()))

                // Second stage: filter students taking Java
                .filter(s -> s.getCourses().contains("Java"))
                .peek(s -> System.out.println("After second filter: " + s.getName()))

                // Third stage: extract grades
                .mapToInt(Student::getGrade)
                .peek(grade -> System.out.println("Grade mapped: " + grade))

                // Final stage: calculate average
                .average()
                .orElse(0);

        System.out.println("Average grade: " + averageGrade);

    }

    private static void lazyEvaluationDemo() {
        System.out.println("Lazy Evaluation Demonstration:");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("\nCreating a stream with intermediate operations:");
        Stream<Integer> stream = numbers.stream()
                .filter(n -> {
                    System.out.println("Filtering: " + n);
                    return n % 2 == 0;
                })
                .map(n -> {
                    System.out.println("Mapping: " + n);
                    return n * n;
                });

        System.out.println("Notice nothing has been printed yet - operations haven't executed!");

        System.out.println("\nNow adding a terminal operation (forEach):");
        stream.forEach(n -> System.out.println("Final value: " + n));

    }

    private static void parallelismDemo() {

        // Create a large list of numbers
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 10_000_000; i++) {
            numbers.add(i);
        }

        System.out.println("\nProcessing 10 million numbers...");

        // Sequential processing
        long startTimeSeq = System.currentTimeMillis();
        long sequentialSum = numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToLong(n -> n * n)
                .sum();
        long endTimeSeq = System.currentTimeMillis();

        System.out.println("Sequential result: " + sequentialSum);
        System.out.println("Sequential time: " + (endTimeSeq - startTimeSeq) + " ms");

        // Parallel processing
        long startTimePar = System.currentTimeMillis();
        long parallelSum = numbers.parallelStream()
                .filter(n -> n % 2 == 0)
                .mapToLong(n -> n * n)
                .sum();
        long endTimePar = System.currentTimeMillis();

        System.out.println("Parallel result: " + parallelSum);
        System.out.println("Parallel time: " + (endTimePar - startTimePar) + " ms");

        System.out.println("\nParallel Stream with thread info:");
        IntStream.range(1, 10)
                .parallel()
                .forEach(i -> System.out.println("Processing " + i +
                        " on thread " + Thread.currentThread().getName()));

    }

}
