package ObjectAndClassesExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {

    static class Student {
        String firstName;
        String LastName;
        Double grade;

        public Student(String firstName, String lastName, Double grade) {
            this.firstName = firstName;
            LastName = lastName;
            this.grade = grade;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return LastName;
        }

        public Double getGrade() {
            return grade;
        }

        @Override
        public String toString() {
            return String.format("%s %s: %.2f", getFirstName(), getLastName(), getGrade());
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Student> studentList = new ArrayList<>();
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split("\\s+");
            String firstName = data[0];
            String lastName = data[1];
            double grade = Double.parseDouble(data[2]);

            Student student = new Student(firstName, lastName, grade);

            studentList.add(student);

        }
        studentList.stream()
                .sorted((p1, p2) -> Double.compare(p2.getGrade(), p1.getGrade()))
                .forEach(student -> System.out.println(student.toString()));
    }
}
