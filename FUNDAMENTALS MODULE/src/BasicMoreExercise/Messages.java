package BasicMoreExercise;

import java.util.Scanner;

public class Messages {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        String word = "";
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            for (int j = 0; j <input.length(); j++) {

                switch (input.charAt(j)) {
                    case '0':
                        word = " ";
                        break;
                    case '2':
                        if (input.length() == 1) {
                            word = "a";
                        } else if (input.length() == 2) {
                            word = "b";
                        } else
                            word = "c";
                        break;
                    case '3':
                        if (input.length() == 1) {
                            word = "d";
                        } else if (input.length() == 2) {
                            word = "e";
                        } else
                            word = "f";
                        break;
                    case '4':
                        if (input.length() == 1) {
                            word = "g";
                        } else if (input.length() == 2) {
                            word = "h";
                        } else
                            word = "i";
                        break;
                    case '5':
                        if (input.length() == 1) {
                            word = "j";
                        } else if (input.length() == 2) {
                            word = "k";
                        } else
                            word = "l";
                        break;
                    case '6':
                        if (input.length() == 1) {
                            word = "m";
                        } else if (input.length() == 2) {
                            word = "n";
                        } else
                            word = "o";
                        break;
                    case '7':
                        if (input.length() == 1) {
                            word = "p";
                        } else if (input.length() == 2) {
                            word = "q";
                        } else if (input.length() == 3) {
                            word = "r";
                        } else {
                            word = "s";
                        }
                        break;
                    case '8':
                        if (input.length() == 1) {
                            word = "t";
                        } else if (input.length() == 2) {
                            word = "u";
                        } else
                            word = "v";
                        break;
                    case '9':
                        if (input.length() == 1) {
                            word = "w";
                        } else if (input.length() == 2) {
                            word = "x";
                        } else if (input.length() == 3) {
                            word = "y";
                        } else {
                            word = "z";
                        }
                }
            }
            System.out.print(word);
        }
    }
}