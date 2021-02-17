package NestedLoopsExercise;

import java.util.Scanner;

public class SumPrimeNonPrime {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int primeSum = 0;
        int nonPrimeSum = 0;

        while (!input.equals("stop")) {
            boolean isNonPrime = false;

            int value = Integer.parseInt(input);

            if(value<0){
                input = scan.nextLine();
                System.out.println("Number is negative.");
                continue;
            }

            for (int i = 2; i < value; i++) {
                if (value%i==0){
                    isNonPrime=true;
                    break;
                }else {
                    isNonPrime=false;
                }
            }
            if(isNonPrime){
                nonPrimeSum+=value;
            }
            else {
                primeSum+=value;
            }
            input = scan.nextLine();
        }
        System.out.printf("Sum of all prime numbers is: %d%n", primeSum);
        System.out.printf("Sum of all non prime numbers is: %d", nonPrimeSum);
    }
}
