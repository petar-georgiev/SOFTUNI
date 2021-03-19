package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class Print_Part_Of_The_ASCII_Table {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int m = Integer.parseInt(scan.nextLine());

        for (int i = n; i <= m; i++) {
            System.out.print((char) (i) + " ");
        }
    }
}
