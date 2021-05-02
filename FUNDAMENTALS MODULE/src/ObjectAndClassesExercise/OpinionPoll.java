package ObjectAndClassesExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OpinionPoll {

    static class Person {
        String name;
        int age;


        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }


        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String toString(String name, int age) {
            return String.format("%s - %d", getName(), getAge());

        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();


        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(" ");

            String name = input[0];
            int age = Integer.parseInt(input[1]);

            Person person = new Person(name, age);

            personList.add(person);

        }

        personList.stream()
                .filter(person -> person.getAge()>30)
                .sorted((p1,p2) -> p1.getName().compareTo(p2.getName()))
                .forEach(person -> System.out.println(person.toString(person.name, person.age)));

    }
}
