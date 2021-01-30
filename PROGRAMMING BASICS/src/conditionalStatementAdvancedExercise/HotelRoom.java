package conditionalStatementAdvancedExercise;

import java.util.Scanner;

public class HotelRoom {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String mounth = scan.nextLine();
        int nights = Integer.parseInt(scan.nextLine());
        double studio = 0.0;
        double apartment = 0.0;
        double pro = 0.0;

        switch (mounth) {
            case "May":
                studio = 50;
                if (nights > 7 && nights <= 14) {
                    pro = studio * 0.05;
                    studio -= pro;
                }
                if (nights > 14) {
                    pro = studio * 0.3;
                    studio -= pro;
                }
                apartment = 65;
                if (nights > 14) {
                    pro = apartment * 0.1;
                    apartment -= pro;
                }

                break;
            case "October":
                studio = 50;
                if (nights > 7 && nights <= 14) {
                    pro = studio * 0.05;
                    studio -= pro;
                }
                if (nights > 14) {
                    pro = studio * 0.3;
                    studio -= pro;
                }
                apartment = 65;
                if (nights > 14) {
                    pro = apartment * 0.1;
                    apartment -= pro;
                }
                break;
            case "June":
                studio = 75.2;
                if (nights > 14) {
                    pro = studio * 0.2;
                    studio -= pro;
                }
                apartment = 68.7;
                if (nights > 14) {
                    pro = apartment * 0.1;
                    apartment -= pro;
                }
                break;
            case "September":
                studio = 75.2;
                if (nights > 14) {
                    pro = studio * 0.2;
                    studio -= pro;
                }
                apartment = 68.7;
                if (nights > 14) {
                    pro = apartment * 0.1;
                    apartment -= pro;
                }
                break;
            case "July":
                studio = 76;
                apartment = 77;
                if (nights > 14) {
                    pro = apartment * 0.1;
                    apartment -= pro;
                }
                break;
            case "August":
                studio = 76;
                apartment = 77;
                if (nights > 14) {
                    pro = apartment * 0.1;
                    apartment -= pro;
                }
                break;
        }
        System.out.printf("Apartment: %.2f lv.%n", apartment * nights);
        System.out.printf("Studio: %.2f lv.", studio * nights);
    }
}
