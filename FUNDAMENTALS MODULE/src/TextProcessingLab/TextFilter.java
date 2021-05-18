package TextProcessingLab;

import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] keys = scan.nextLine().split(", ");

        String input = scan.nextLine();

        for (String key : keys) {
            input = input.replace(key, repeat("*", key.length()));
        }
        System.out.println(input);
    }

    private static String repeat(String word, int count) {
        String[] repeatArr = new String[count];
        for (int i = 0; i < count; i++) {
            repeatArr[i] = word;
        }
        return String.join("", repeatArr);
    }
}
