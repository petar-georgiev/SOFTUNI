package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class Water_Overflow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int sumLiters = 0;
        for (int i = 0; i < n; i++) {
            int liters = Integer.parseInt(scan.nextLine());
            if (liters > (255 - sumLiters)) {
                System.out.println("Insufficient capacity!");
            } else {
                sumLiters += liters;
            }
        }
        System.out.println(sumLiters);
    }
}
