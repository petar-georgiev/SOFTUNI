package MethodsExercise;

import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a = Integer.parseInt(scan.nextLine());
        int b = Integer.parseInt(scan.nextLine());
        int c = Integer.parseInt(scan.nextLine());
        System.out.println(subtractTwoNumbers(addTwoNumbers(a, b),c));

    }

    public static int addTwoNumbers(int a, int b) {
        return a + b;
    }

    public static int subtractTwoNumbers(int a, int b) {
        return a - b;
    }
}
