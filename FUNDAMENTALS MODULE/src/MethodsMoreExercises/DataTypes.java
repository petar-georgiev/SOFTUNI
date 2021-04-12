package MethodsMoreExercises;

import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String type = scan.nextLine();
        String value = scan.nextLine();
        getValue(type,value);
    }

    public static void getValue(String type, String value) {
        switch (type) {
            case "int":
                int numberInt = Integer.parseInt(value);
                System.out.println(numberInt * 2);
                break;
            case "real":
                double numberDouble = Double.parseDouble(value);
                System.out.printf("%.2f",(numberDouble * 1.50));
                break;
            case "string":
                System.out.println("$" + value + "$");
                break;
        }

    }
}
