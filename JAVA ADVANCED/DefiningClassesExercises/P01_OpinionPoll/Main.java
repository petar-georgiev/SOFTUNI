package DefiningClassesExercises.P01_OpinionPoll;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Person> personList = new LinkedList<>();
        int n = Integer.parseInt(scan.nextLine());

        while (n-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            Person person = new Person(name, age);
            personList.add(person);
        }
        personList.stream().sorted(Comparator.comparing(s -> s.name)).filter(f -> f.age > 30).forEach(e -> {
            System.out.printf("%s - %d%n", e.name, e.age);
        });
    }
}
