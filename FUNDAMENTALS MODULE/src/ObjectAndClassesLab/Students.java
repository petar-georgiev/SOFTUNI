package ObjectAndClassesLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {

    static class Student {
        String firstName;
        String secondName;
        int age;
        String hometown;

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setSecondName(String secondName) {
            this.secondName = secondName;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public void setHometown(String hometown) {
            this.hometown = hometown;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getSecondName() {
            return secondName;
        }

        public Integer getAge() {
            return age;
        }

        public String getHometown() {
            return hometown;
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Student> studentList = new ArrayList<>();

        String input = scan.nextLine();

        while (!input.equals("end")) {

            String[] data = input.split("\\s+");

            String firstName = data[0];
            String secondName = data[1];
            int age = Integer.parseInt(data[2]);
            String hometown = data[3];

            Student student = new Student();
            student.firstName = firstName;
            student.secondName = secondName;
            student.age = age;
            student.hometown = hometown;

            studentList.add(student);

            input = scan.nextLine();
        }

        String filterHometown = scan.nextLine();

        for (Student student : studentList) {
                if(student.getHometown().equals(filterHometown)){
                    System.out.printf("%s %s is %d years old %n",
                            student.getFirstName(),
                            student.getSecondName(),
                            student.getAge());
                }
        }
    }
}
