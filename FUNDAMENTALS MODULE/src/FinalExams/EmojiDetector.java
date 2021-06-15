package FinalExams;

import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String regex = "([*]{2}|[:]{2})(?<emoji>[A-Z][a-z]{2,})\\1";
        String digRegex = "\\d";
        Pattern pattern = Pattern.compile(regex);
        Pattern digPattern = Pattern.compile(digRegex);

        String input = scan.nextLine();

        Matcher matcher = pattern.matcher(input);
        Matcher digMatcher = digPattern.matcher(input);

        Map<String, Integer> sumMap = new LinkedHashMap<>();

        double totalCool = 1;
        while (digMatcher.find()) {
            int digit = Integer.parseInt(digMatcher.group());
            totalCool *= digit;
        }
        int sumChar = 0;
        int counter = 0;
        while (matcher.find()) {
            for (int i = 2; i < matcher.group().length() - 2; i++) {
                char current = matcher.group().charAt(i);
                int charValue = matcher.group().charAt(i);
                sumChar += charValue;
            }
            if (sumChar > totalCool) {
                sumMap.put(matcher.group(), sumChar);
            }
            sumChar = 0;
            counter++;
        }
        System.out.printf("Cool threshold: %.0f%n", totalCool);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", counter);

        for (Map.Entry<String, Integer> entry : sumMap.entrySet()) {
            System.out.println(entry.getKey());
        }
    }
}
