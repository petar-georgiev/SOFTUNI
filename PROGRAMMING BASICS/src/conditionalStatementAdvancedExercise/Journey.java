package conditionalStatementAdvancedExercise;

import java.util.Scanner;

public class Journey {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budjet = Double.parseDouble(scan.nextLine());
        String season = scan.nextLine();
        String destination = "";
        double price = 0.0;
        String type = "";

        if (season.equals("summer")) {
            if (budjet <= 100) {
                destination = "Bulgaria";
                price = budjet*0.3;
                type="Camp";
            }
            if (budjet > 100 && budjet <= 1000) {
                destination = "Balkans";
                price =budjet* 0.4;
                type="Camp";
            }
            if (budjet > 1000) {
                destination = "Europe";
                price =budjet* 0.9;
                type="Hotel";
            }

        }
        else if (season.equals("winter")) {
            if (budjet <= 100) {
                destination = "Bulgaria";
                price =budjet* 0.7;
            }
            if (budjet > 100 && budjet <= 1000) {
                destination = "Balkans";
                price =budjet* 0.8;
            }
            if (budjet > 1000) {
                destination = "Europe";
                price =budjet* 0.9;
            }
            type="Hotel";
        }

        System.out.printf("Somewhere in %s%n", destination);
        System.out.printf("%s - %.2f",type, price);
    }
}
