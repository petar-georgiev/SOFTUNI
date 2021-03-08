package BasicMoreExercise;

import java.util.Scanner;

public class Gaming_Store {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double currentBalance = Double.parseDouble(scan.nextLine());
        double spent =currentBalance;
        String input = "";

        while (!input.equals("Game Time")) {
                if((input.equals(""))||(input.equals("OutFall 4"))||(input.equals("CS: OG"))||(input.equals("Zplinter Zell"))||(input.equals("Honored 2"))||(input.equals("RoverWatch"))||(input.equals("RoverWatch Origins Edition"))) {
                    switch (input) {
                        case "OutFall 4":
                            if(currentBalance<39.99){
                                System.out.println("Too Expensive");
                                break;
                            }
                            System.out.println("Bought OutFall 4");
                            currentBalance -= 39.99;
                            if (currentBalance <= 0) {
                                currentBalance += 39.99;
                                System.out.println("Out of money");
                                return;
                            }
                            break;
                        case "CS: OG":
                            if(currentBalance<15.99){
                                System.out.println("Too Expensive");
                                break;
                            }
                            System.out.println("Bought CS: OG");
                            currentBalance -= 15.99;
                            if (currentBalance <= 0) {
                                currentBalance += 15.99;
                                System.out.println("Out of money");
                                return;
                            }
                            break;
                        case "Zplinter Zell":
                            if(currentBalance<19.99){
                                System.out.println("Too Expensive");
                                break;
                            }
                            System.out.println("Bought Zplinter Zell");
                            currentBalance -= 19.99;
                            if (currentBalance <= 0) {
                                currentBalance += 19.99;
                                System.out.println("Out of money");
                                return;
                            }
                            break;
                        case "Honored 2":

                            if(currentBalance<59.99){
                                System.out.println("Too Expensive");
                                break;
                            }
                            System.out.println("Bought Honored 2");
                            currentBalance -= 59.99;
                            if (currentBalance <= 0) {
                                currentBalance += 59.99;
                                System.out.println("Out of money");
                                return;
                            }
                            break;
                        case "RoverWatch":

                            if(currentBalance<29.99){
                                System.out.println("Too Expensive");
                                break;
                            }
                            System.out.println("Bought RoverWatch");
                            currentBalance -= 29.99;
                            if (currentBalance <= 0) {
                                currentBalance += 29.99;
                                System.out.println("Out of money");
                                return;
                            }
                            break;
                        case "RoverWatch Origins Edition":

                            if(currentBalance<39.99){
                                System.out.println("Too Expensive");
                                break;
                            }
                            System.out.println("Bought RoverWatch Origins Edition");
                            currentBalance -= 39.99;
                            if (currentBalance <= 0) {
                                currentBalance += 39.99;
                                System.out.println("Out of money");
                                return;
                            }
                            break;
                    }
                    input = scan.nextLine();
                }
                else {
                    System.out.println("Not Found");
                    input = scan.nextLine();
                }
        }
        spent-=currentBalance;
        System.out.printf("Total spent: $%.2f. Remaining: $%.2f",spent,currentBalance);

    }
}
