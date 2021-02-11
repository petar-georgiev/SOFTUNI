package NestedLoopsLab;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int multiply = 0;
        for (int i = 1; i <= 10; i++) {

            for (int j = 1; j <= 10; j++) {
                multiply = i*j;
                System.out.printf("%d * %d = %d%n", i, j, multiply);
            }
        }
    }
}
