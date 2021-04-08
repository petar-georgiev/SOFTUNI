package MethodsExercise;

import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input1 = scan.nextLine();
        String input2 = scan.nextLine();
        getAllSymbols(input1, input2);

    }

    public static void getAllSymbols(String first, String second) {

        char charFirst = first.charAt(0);
        char charSecond = second.charAt(0);


        for (int i = charFirst + 1; i < charSecond; i++) {
            System.out.print((char) i + " ");
        }
        if (charSecond < charFirst) {
            for (int i = charSecond + 1; i < charFirst; i++)
                System.out.print((char) i + " ");
        }
    }
}
