package E06Animals;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();

        String input = scan.nextLine();

        while (!input.equals("Beast!")) {

            String type = input;
            String[] data = scan.nextLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            Gender gender = Gender.valueOf(data[2].toUpperCase());
            try {
                Animal animal = new Animal(name, age, gender);
                printOutput(type, animal);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            input = scan.nextLine();
        }
    }

    private static void printOutput(String type, Animal animal) {

        switch (type) {
            case "Dog":
                Dog dog = new Dog(animal.getName(), animal.getAge(), animal.getGender());
                System.out.println(dog);
                break;
            case "Cat":
                Cat cat = new Cat(animal.getName(), animal.getAge(), animal.getGender());
                System.out.println(cat);
                break;
            case "Frog":
                Frog frog = new Frog(animal.getName(), animal.getAge(), animal.getGender());
                System.out.println(frog);
                break;
            case "Kittens":
                Kitten kitten = new Kitten(animal.getName(), animal.getAge());
                System.out.println(kitten);
                break;
            case "Tomcat":
                Tomcat tomcat = new Tomcat(animal.getName(), animal.getAge());
                System.out.println(tomcat);
                break;
            default:
                throw new IllegalArgumentException("Invalid input!");
        }
    }
}
