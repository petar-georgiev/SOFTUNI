package E03BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Birthable> birthableList = new ArrayList<>();
        String input = scan.nextLine();
        while (!input.equals("End")) {

            String[] tokens = input.split("\\s+");
            switch (tokens[0]) {
                case "Citizen":
                    Citizen citizen = new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]);
                    birthableList.add(citizen);
                    break;
                case "Pet":
                    Birthable pet = new Pet(tokens[1], tokens[2]);
                    birthableList.add(pet);
                    break;
            }

            input = scan.nextLine();
        }
        String endWith = scan.nextLine();
        birthableList.stream().filter(s -> s.getBirthDate().endsWith(endWith))
                .forEach(s -> System.out.println(s.getBirthDate()));
    }
}
