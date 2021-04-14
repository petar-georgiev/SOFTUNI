package MethodsMoreExercises;

import java.util.Scanner;

public class MultiplicationSign {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String a = scan.nextLine();
        String b = scan.nextLine();
        String c = scan.nextLine();
        getSign(a, b, c);
    }

    public static void getSign(String input1, String input2, String input3) {
        if (input1.contains("0") || input2.contains("0") || input3.contains("0"))
            System.out.println("zero");
        else if ((input1.contains("-") && input2.contains("-") && input3.contains("-")))
            System.out.println("negative");
        else if ((input1.contains("-") && input2.contains("-"))
                || (input1.contains("-") && input3.contains("-"))
                || (input2.contains("-") && input3.contains("-")))
            System.out.println("positive");
        else if ((input1.contains("-") || input2.contains("-") || input3.contains("-")))
            System.out.println("negative");
        else
            System.out.println("positive");
    }
}
