package MethodsLab;

import java.util.Scanner;

public class Calculations {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String operation = scan.nextLine();
        int firstNumber = Integer.parseInt(scan.nextLine());
        int secondNumber = Integer.parseInt(scan.nextLine());

        if(operation.equals("add")){
            add(firstNumber,secondNumber);

        }
        if(operation.equals("multiply")){
            multiply(firstNumber,secondNumber);
        }
        if(operation.equals("subtract")){
            subtract(firstNumber,secondNumber);
        }
        if(operation.equals("divide")){
            divide(firstNumber,secondNumber);
        }

        }

    public static void add(int a, int b){
       int sum = a+b;
        System.out.println(sum);

    }
    public static void multiply(int a, int b){
        int sum = a*b;
        System.out.println(sum);
    }
    public static void subtract(int a, int b){
        int sum = a-b;
        System.out.println(sum);
    }
    public static void divide(int a, int b){
        int sum = a/b;
        System.out.println(sum);
    }
}
