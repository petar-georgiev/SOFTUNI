package com.company;

import java.util.Scanner;

public class SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int odd=-1;
        int sum = 0;
        for (int i = 1; i <= n; i++) {

            odd=odd+2;
            sum+=odd;
            System.out.println(odd);
        }
        System.out.printf("Sum: %d", sum);
    }
}
