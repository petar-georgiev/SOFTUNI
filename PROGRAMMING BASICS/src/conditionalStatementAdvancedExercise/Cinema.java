package conditionalStatementAdvancedExercise;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String type = scan.nextLine();
        int rom = Integer.parseInt(scan.nextLine());
        int column = Integer.parseInt(scan.nextLine());
        int quantity = rom*column;

        if(type.equals("Premiere")){
            System.out.printf("%.2f leva", quantity*12.00);
        }
        else if (type.equals("Normal")){
            System.out.printf("%.2f leva", quantity*7.50);
        }
        else if(type.equals("Discount")){
            System.out.printf("%.2f leva", quantity*5.00);
        }
    }
}
