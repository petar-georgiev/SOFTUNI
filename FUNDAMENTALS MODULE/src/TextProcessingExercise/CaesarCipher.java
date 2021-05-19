package TextProcessingExercise;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        sb.append(scan.nextLine());
        for (int i = 0; i < sb.length(); i++) {
        char symbol = sb.charAt(i);
            char newSymbol = (char) (symbol+3);
            System.out.print(newSymbol);

        }
    }
}
