package FinalExams;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String regex = "(#|@)((?<word1>[A-Za-z]{3,})\\1{2,2}(?<word2>[A-Za-z]{3,}))\\1";
        String input = scan.nextLine();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        boolean check = false;
        int counter = 0;
        Map<String, String> mirrorWords = new LinkedHashMap<>();

        while (matcher.find()) {
            check = true;
            counter++;
            String match1 = matcher.group("word1");
            String match2 = matcher.group("word2");
            StringBuilder word1 = new StringBuilder(match1);
            StringBuilder word2 = new StringBuilder(match2);
            if (word1.toString().equals(word2.reverse().toString())) {
                mirrorWords.put(String.valueOf(word1), String.valueOf(word2.reverse()));
            }
        }
        if (!check) {
            System.out.println("No word pairs found!");
        } else {
            System.out.printf("%d word pairs found!%n", counter);
        }
        if (mirrorWords.isEmpty()) {
            System.out.println("No mirror words!");
        } else {

            String output = mirrorWords.entrySet().stream()
                    .map(s -> s.getKey() + " <=> " + s.getValue())
                    .collect(Collectors.joining(", "));

            System.out.printf("The mirror words are: %n%s", output);
        }
    }
}
