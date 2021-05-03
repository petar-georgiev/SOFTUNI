package ObjectAndClassesExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderByAge {

    static class Person {
        String name;
        int id;
        int age;

        public Person(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }


        @Override
        public String toString() {
            return String.format("%s with ID: %d is %d years old.", name, id, age);
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        List<Person> personList = new ArrayList<>();

        while (!input.equals("End")) {

            String[] data = input.split("\\s+");
            String name = data[0];
            int id = Integer.parseInt(data[1]);
            int age = Integer.parseInt(data[2]);

            Person person = new Person(name, id, age);
            personList.add(person);


            input = scan.nextLine();
        }

        personList.stream()
                .sorted((p1,p2)->Integer.compare(p1.age,p2.age))
                .forEach(System.out::println);
    }
}
