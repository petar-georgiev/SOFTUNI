package com.company;

import java.util.Scanner;

public class Refactor_Sum_of_Odd_Number {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int sum = 1;
        int a=0;
        for (int i = 0; i < n; i++) {
            System.out.println(2 * i + 1);
            a=2*i+1;
            sum += a;

        }

        System.out.printf("Sum: %d%n", sum-1);

        }
}
