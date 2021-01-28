package conditionalStatementAdvancedLab;

import java.util.Scanner;

public class FruitShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String product = scan.nextLine();
        String day = scan.nextLine();
        double quantity = Double.parseDouble(scan.nextLine());
        if (day.equals("Saturday") || day.equals("Sunday")) {
            switch (product) {
                case "banana":
                    System.out.printf("%.2f", quantity * 2.70);
                    break;
                case "apple":
                    System.out.printf("%.2f", quantity * 1.25);
                    break;
                case "orange":
                    System.out.printf("%.2f", quantity * 0.90);
                    break;
                case "grapefruit":
                    System.out.printf("%.2f", quantity * 1.60);
                    break;
                case "kiwi":
                    System.out.printf("%.2f", quantity * 3.00);
                    break;
                case "pineapple":
                    System.out.printf("%.2f", quantity * 5.60);
                    break;
                case "grapes":
                    System.out.printf("%.2f", quantity * 4.20);
                    break;
                default:
                    System.out.printf("error");
            }
        } else if (day.equals("Monday") || day.equals("Tuesday") || day.equals("Wednesday") || day.equals("Thursday") ||
                day.equals("Friday")) {
            switch (product) {
                case "banana":
                    System.out.printf("%.2f", quantity * 2.50);
                    break;
                case "apple":
                    System.out.printf("%.2f", quantity * 1.20);
                    break;
                case "orange":
                    System.out.printf("%.2f", quantity * 0.85);
                    break;
                case "grapefruit":
                    System.out.printf("%.2f", quantity * 1.45);
                    break;
                case "kiwi":
                    System.out.printf("%.2f", quantity * 2.70);
                    break;
                case "pineapple":
                    System.out.printf("%.2f", quantity * 5.50);
                    break;
                case "grapes":
                    System.out.printf("%.2f", quantity * 3.85);
                    break;
                default:
                    System.out.printf("error");
            }
        } else {
            System.out.printf("error");
        }
    }
}
