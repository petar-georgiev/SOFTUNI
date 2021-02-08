package WhileLoopLab;

import java.util.Scanner;

public class AccountBalance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double total = 0.0;

        while (true) {
            String input = scan.nextLine();
            if (input.equals("NoMoreMoney")) {
                break;
            }
            double num = Double.parseDouble(input);

            if (num < 0) {
                System.out.println("Invalid operation!");
                break;
            }
            System.out.printf("Increase: %.2f%n", num);
            total += num;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
