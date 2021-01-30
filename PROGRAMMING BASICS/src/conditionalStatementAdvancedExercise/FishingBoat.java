package conditionalStatementAdvancedExercise;

import java.util.Scanner;

public class FishingBoat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int budjet = Integer.parseInt(scan.nextLine());
        String season = scan.nextLine();
        int fishers = Integer.parseInt(scan.nextLine());
        double rent = 0.0;
        double pro = 0.0;
        System.out.println();
        switch (season) {
            case "Spring":
                rent = 3000;
                break;
            case "Summer":
                rent = 4200;
                break;
            case "Autumn":
                rent = 4200;
                break;
            case "Winter":
                rent = 2600;
                break;
        }
        if (fishers <= 6) {
            pro = rent * 0.1;
            rent = rent - pro;
        }
        else if (fishers >= 7 && fishers <= 11) {
            pro = rent * 0.15;
            rent = rent - pro;
        }
        else if( fishers >= 12){
            pro = rent * 0.25;
            rent = rent - pro;
        }
        if(!season.equals("Autumn")){
            if(fishers%2==0){
                pro = rent * 0.05;
                rent = rent - pro;
            }
        }
        if(budjet>=rent){
            System.out.printf("Yes! You have %.2f leva left.", budjet-rent);
        }
        else {
            System.out.printf("Not enough money! You need %.2f leva.", rent-budjet);
        }
    }
}
