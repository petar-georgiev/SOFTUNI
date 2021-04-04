package MethodsLab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double digit = Double.parseDouble(scan.nextLine());
        int power = Integer.parseInt(scan.nextLine());
        double result = powerDigits(digit,power);
        System.out.println(new DecimalFormat("0.#######").format(result));
    }
    public static double powerDigits(double digit, int power){

        return Math.pow(digit,power);
    }
}
