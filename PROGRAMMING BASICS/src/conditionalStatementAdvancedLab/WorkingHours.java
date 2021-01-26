package conditionalStatementAdvancedLab;

import java.util.Scanner;

public class WorkingHours {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int hour = Integer.parseInt(scan.nextLine());
        String day = scan.nextLine();
        if (hour >= 10 && hour <= 18) {
            switch (day) {
                case "Monday":
                    System.out.println("open");
                    break;
                case "Tuesday":
                    System.out.println("open");
                    break;
                case "Wednesday":
                    System.out.println("open");
                    break;
                case "Thursday":
                    System.out.println("open");
                    break;
                case "Friday":
                    System.out.println("open");
                    break;
                case "Saturday":
                    System.out.println("open");
                    break;
                default:
                    System.out.println("closed");
                    break;
            }
        } else {
            System.out.println("closed");
        }
    }
}
