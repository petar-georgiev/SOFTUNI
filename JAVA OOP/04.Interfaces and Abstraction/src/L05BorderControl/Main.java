package L05BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Identifiable> identifiableList = new ArrayList<>();

        String input = scan.nextLine();

        while (!input.equals("End")) {

            String[] tokens = input.split("\\s+");
            String model;
            String name;
            int age;
            String id;

            if (tokens.length == 3) {
                name = tokens[0];
                age = Integer.parseInt(tokens[1]);
                id = tokens[2];
                Identifiable citizen = new Citizen(name, age, id);
                identifiableList.add(citizen);
            } else if (tokens.length == 2) {
                model = tokens[0];
                id = tokens[1];
                Identifiable robot = new Robot(id, model);
                identifiableList.add(robot);
            }
            input = scan.nextLine();
        }
        String endWith = scan.nextLine();
        for (Identifiable i : identifiableList) {
            if (i.getId().endsWith(endWith)) {
                System.out.println(i.getId());
            }
        }
    }
}
