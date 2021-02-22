package BasicLab;

import java.util.Scanner;

public class Theatre_Promotions {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String typeOfDay = scan.nextLine();
        int days = Integer.parseInt(scan.nextLine());
        int ticketPrice = 0;

        switch (typeOfDay) {
            case "Weekday":
                if (days >= 0 && days <= 18) {
                    ticketPrice = 12;
                    System.out.printf("%d$", ticketPrice);
                } else if (days > 18 && days <= 64) {
                    ticketPrice = 18;
                    System.out.printf("%d$", ticketPrice);
                } else if (days > 64 && days <= 122) {
                    ticketPrice = 12;
                    System.out.printf("%d$", ticketPrice);
                } else {
                    System.out.println("Error!");
                }
                break;
            case "Weekend":
                if (days >= 0 && days <= 18) {
                    ticketPrice = 15;
                    System.out.printf("%d$", ticketPrice);
                } else if (days > 18 && days <= 64) {
                    ticketPrice = 20;
                    System.out.printf("%d$", ticketPrice);
                } else if (days > 64 && days <= 122) {
                    ticketPrice = 15;
                    System.out.printf("%d$", ticketPrice);
                } else {
                    System.out.println("Error!");
                }
                break;
            case "Holiday":
                if (days >= 0 && days <= 18) {
                    ticketPrice = 5;
                    System.out.printf("%d$", ticketPrice);
                } else if (days > 18 && days <= 64) {
                    ticketPrice = 12;
                    System.out.printf("%d$", ticketPrice);
                } else if (days > 64 && days <= 122) {
                    ticketPrice = 10;
                    System.out.printf("%d$", ticketPrice);
                } else {
                    System.out.println("Error!");
                }
                break;

        }

    }
}
