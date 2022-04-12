package E03WildFarm;

import E03WildFarm.animals.*;
import E03WildFarm.foods.Food;
import E03WildFarm.foods.Meat;
import E03WildFarm.foods.Vegetable;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();

        String line = scan.nextLine();

        while (!line.equals("End")) {

            Animal animal = createAnimal(line.split("\\s+"));
            Food food = createFood(scan.nextLine().split("\\s+"));

            animal.makeSound();

            try {
                animal.eat(food);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

            animals.add(animal);

            for (Animal a : animals) {
                System.out.println(a.toString());
            }
            line = scan.nextLine();
        }
    }

    private static Animal createAnimal(String[] tokens) {
        switch (tokens[0]) {
            case "Mouse":
                return new Mouse(tokens[1], tokens[0], Double.parseDouble(tokens[2]), tokens[3]);

            case "Cat":
                return new Cat(tokens[1], tokens[0], Double.parseDouble(tokens[2]), tokens[3], tokens[4]);

            case "Tiger":
                return new Tiger(tokens[1], tokens[0], Double.parseDouble(tokens[2]), tokens[3]);

            case "Zebra":
                return new Zebra(tokens[1], tokens[0], Double.parseDouble(tokens[2]), tokens[3]);

            default:
                throw new IllegalArgumentException("Unknown animal type " + tokens[0]);
        }
    }

    private static Food createFood(String[] tokens) {
        int quantity = Integer.parseInt(tokens[1]);
        return tokens[0].equals("Meat")
                ? new Meat(quantity)
                : new Vegetable(quantity);
    }
}
