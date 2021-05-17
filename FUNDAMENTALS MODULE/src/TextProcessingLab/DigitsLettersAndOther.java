package TextProcessingLab;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StringBuilder digits = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder other = new StringBuilder();

        String input = scan.nextLine();

        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                digits.append(input.charAt(i));
            } else if (Character.isAlphabetic(input.charAt(i))) {
                letters.append(input.charAt(i));
            } else {
                other.append(input.charAt(i));
            }
        }
        System.out.println(digits);
        System.out.println(letters);
        System.out.println(other);
    }
}
