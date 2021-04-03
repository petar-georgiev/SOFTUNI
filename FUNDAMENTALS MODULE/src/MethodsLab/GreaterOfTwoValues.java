package MethodsLab;

import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        switch (input) {
            case "int":
                int a = Integer.parseInt(scan.nextLine());
                int b = Integer.parseInt(scan.nextLine());
                System.out.println(getMax(a, b));
                break;
            case "char":
                char first = scan.nextLine().charAt(0);
                char second = scan.nextLine().charAt(0);
                System.out.println(getMax(first, second));
                break;
            case "string":
                String strFirst = scan.nextLine();
                String strSecond = scan.nextLine();
                System.out.println(getMax(strFirst, strSecond));
                break;

        }
    }

    public static int getMax(int first, int second) {
        int max = 0;
        if (first > second)
            max = first;
        else
            max = second;

        return max;

    }

    public static char getMax(char first, char second) {
        if (first > second)
            return first;
        else
            return second;

    }

    public static String getMax(String first, String second) {
        if (first.compareTo(second) > 0)
            return first;
        else
            return second;


    }


    }
