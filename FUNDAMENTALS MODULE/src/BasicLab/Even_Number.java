package BasicLab;

import java.util.Scanner;

public class Even_Number {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int value = Integer.parseInt(scan.nextLine());

        while (value % 2 != 0) {

            if (value % 2 != 0) {

                System.out.println("Please write an even number.");
            }
            value= Integer.parseInt(scan.nextLine());
        }
        System.out.printf("The number is: %d", Math.abs(value));
    }
}
