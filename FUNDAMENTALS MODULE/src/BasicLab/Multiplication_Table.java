package com.company;

import java.util.Scanner;

public class Multiplication_Table {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int multi =0 ;
        for (int i = 1; i <= 10; i++) {
            multi=n*i;
            System.out.printf("%d X %d = %d%n", n, i ,multi);

        }
    }
}
