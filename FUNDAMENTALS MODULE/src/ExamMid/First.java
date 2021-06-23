package ExamMid;

import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        int students = Integer.parseInt(scan.nextLine());
        double priceFlour = Double.parseDouble(scan.nextLine());
        double priceEgg = Double.parseDouble(scan.nextLine());
        double priceApron = Double.parseDouble(scan.nextLine());

        double totalPrice = 0.0;

        if (students % 5 == 0) {
            totalPrice = (priceApron * (students + Math.ceil(students * 0.2)))
                    + (priceEgg * 10 * students)
                    + (priceFlour * students - (students / 5.0 * priceFlour));
        } else {
            totalPrice = (priceApron * (students + Math.ceil(students * 0.2)))
                    + (priceEgg * 10 * students)
                    + (priceFlour * students);
        }
        if (totalPrice <= budget) {
            System.out.printf("Items purchased for %.2f$.", totalPrice);
        } else
            System.out.printf("%.2f$ more needed.", totalPrice - budget);
    }
}
