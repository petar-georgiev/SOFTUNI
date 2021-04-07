package MethodsLab;

import java.util.Scanner;


public class SignOfInteger {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        whatIsTheSign(n);
    }
    public static void whatIsTheSign(int n) {
        if (n<0){
            System.out.printf("The number %d is negative.",n);
        }else if(n>0){
            System.out.printf("The number %d is positive.",n);
        }
        else {
            System.out.printf("The number %d is zero.",n);

        }


    }
}
