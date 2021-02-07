package WhileLoopLab;

import java.util.Scanner;

public class Sequence2kPlus1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int formula = 1;

        while (formula <= n) {
            formula = (formula * 2) + 1;
            System.out.println(formula);
        }
    }
}
