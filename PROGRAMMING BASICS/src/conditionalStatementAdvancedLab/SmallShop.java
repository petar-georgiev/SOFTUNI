package conditionalStatementAdvancedLab;

import java.util.Scanner;

public class SmallShop {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String product = scan.nextLine();
        String town = scan.nextLine();
        double quantity = Double.parseDouble(scan.nextLine());

        if(town.equals("Sofia"))
        {
            switch (product){
                case "coffee":
                    System.out.println(0.5*quantity);
                    break;
                case "water":
                    System.out.println(0.8*quantity);
                    break;
                case "beer":
                    System.out.println(1.2*quantity);
                    break;
                case "sweets":
                    System.out.println(1.45*quantity);
                    break;
                case "peanuts":
                    System.out.println(1.6*quantity);
                    break;
            }
        }
        else if (town.equals("Plovdiv")) {
            switch (product) {
                case "coffee":
                    System.out.println(0.4 * quantity);
                    break;
                case "water":
                    System.out.println(0.7 * quantity);
                    break;
                case "beer":
                    System.out.println(1.15 * quantity);
                    break;
                case "sweets":
                    System.out.println(1.30 * quantity);
                    break;
                case "peanuts":
                    System.out.println(1.5 * quantity);
                    break;
            }
        }
        else if (town.equals("Varna")) {
            switch (product) {
                case "coffee":
                    System.out.println(0.45 * quantity);
                    break;
                case "water":
                    System.out.println(0.7 * quantity);
                    break;
                case "beer":
                    System.out.println(1.10 * quantity);
                    break;
                case "sweets":
                    System.out.println(1.35 * quantity);
                    break;
                case "peanuts":
                    System.out.println(1.55 * quantity);
                    break;
            }
        }
    }
}
