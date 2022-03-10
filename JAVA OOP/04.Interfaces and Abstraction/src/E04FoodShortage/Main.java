package E04FoodShortage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Buyer> buyers = new ArrayList<>();
        int n = Integer.parseInt(scan.nextLine());

        while (n-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");
            Buyer buyer;
            if (tokens.length == 4) {
                buyer = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2], tokens[3]);
            } else {
                buyer = new Rebel(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            }
            buyers.add(buyer);
        }
        int sum = 0;
        String input = scan.nextLine();
        while (!input.equals("End")) {
            for (Buyer buyer : buyers) {
                if (buyer.getName().equals(input)) {
                    buyer.buyFood();
                }
            }
            input = scan.nextLine();
        }
        System.out.println(buyers.stream().mapToInt(Buyer::getFood).sum());
    }
}
