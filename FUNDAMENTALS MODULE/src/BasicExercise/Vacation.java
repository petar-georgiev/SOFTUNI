package BasicExercise;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        String type = scan.nextLine();
        String day = scan.nextLine();
        double total = 0.0;
        double pro = 0.0;
        double total2 = 0.0;

        switch (day) {
            case "Friday":
                if (type.equals("Students")) {
                    total = n * 8.45;
                } else if (type.equals("Business")) {
                    total = n * 10.9;
                    total2 = 10 * 10.9;
                } else if (type.equals("Regular")) {
                    total = n * 15;
                }
                break;

            case "Saturday":
                if (type.equals("Students")) {
                    total = n * 9.8;
                } else if (type.equals("Business")) {
                    total = n * 15.6;
                    total2 = 10 * 15.6;
                } else if (type.equals("Regular")) {
                    total = n * 20;
                }
                break;

            case "Sunday":
                if (type.equals("Students")) {
                    total = n * 10.46;
                } else if (type.equals("Business")) {
                    total = n * 16;
                    total2 = 10 * 16;
                } else if (type.equals("Regular")) {
                    total = n * 22.5;
                }break;
        }
        if (type.equals("Students") && n >= 30) {
            pro = total * 0.15;
            total = total - pro;
        } else if (type.equals("Business") && n >= 100) {
            total = total - total2;
        } else if (type.equals("Regular") && (n >= 10 && n <= 20)) {
            pro = total * 0.05;
            total = total - pro;

        }
        System.out.printf("Total price: %.2f", total);
    }
}
