package conditionalStatementAdvancedExercise;

import java.util.Scanner;

public class SummerOutfit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int degrees = Integer.parseInt(scan.nextLine());
        String dayTime = scan.nextLine();
        String outfit = "";
        String shoes = "";

        if (dayTime.equals("Morning")) {
            if (degrees >= 10 && degrees <= 18) {
                outfit = "Sweatshirt";
                shoes = "Sneakers";
            } else if(degrees >= 18 && degrees <= 24){
                outfit = "Shirt";
                shoes = "Moccasins";
            } else {
                outfit = "T-Shirt";
                shoes="Sandals";
            }
        }
        else if (dayTime.equals("Afternoon")) {
            if (degrees >= 10 && degrees <= 18) {
                outfit = "Shirt";
                shoes = "Moccasins";
            } else if(degrees >= 18 && degrees <= 24){
                outfit = "T-Shirt";
                shoes = "Sandals";
            } else {
                outfit = "Swim Suit";
                shoes="Barefoot";
            }
        }
        else  {
            if (degrees >= 10 && degrees <= 18) {
                outfit = "Shirt";
                shoes = "Moccasins";
            } else if(degrees >= 18 && degrees <= 24){
                outfit = "Shirt";
                shoes = "Moccasins";
            } else {
                outfit = "Shirt";
                shoes = "Moccasins";
            }
        }
        System.out.printf("It's %s degrees, get your %s and %s.", degrees, outfit, shoes);
    }
}
