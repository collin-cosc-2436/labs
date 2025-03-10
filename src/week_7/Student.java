package week_7;

import java.util.List;
import java.util.Objects;

public class Student {
    private final String name;
    private final int grade;
    private final String department;
    private final List<String> courses;

    public Student(String name, int grade, String department, List<String> courses) {
        this.name = name;
        this.grade = grade;
        this.department = department;
        this.courses = courses;
    }

    public String getName() { return name; }
    public int getGrade() { return grade; }
    public String getDepartment() { return department; }
    public List<String> getCourses() { return courses; }

    @Override
    public String toString() {
        return "Student{" + name + ", grade=" + grade + ", department='" + department + "'}";
    }
}
