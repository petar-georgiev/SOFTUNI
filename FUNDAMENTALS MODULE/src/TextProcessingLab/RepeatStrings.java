package TextProcessingLab;

import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        String[] input = scan.nextLine().split("\\s+");
        for (int i = 0; i < input.length; i++) {
            String word = input[i];
            for (int j = 0; j < word.length(); j++) {
                result.append(word);
            }
        }
        System.out.println(result);
    }
}