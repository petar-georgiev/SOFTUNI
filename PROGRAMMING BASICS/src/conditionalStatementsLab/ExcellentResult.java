package conditionalStatementsLab;

import java.util.Scanner;

public class ExcellentResult {
    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        if (a >= 5) {
            System.out.println("Excellent!");

        } else {
            System.out.println("");
        }
    }
}
