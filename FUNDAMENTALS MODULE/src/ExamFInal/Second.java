package ExamFInal;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Second {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String regex = "([\\*|\\@])(?<tag>[A-Z][a-z]{2,})(\\1)\\:\\s\\[(?<letter1>[A-Za-z])]\\|\\[(?<letter2>[A-Za-z])]\\|\\[(?<letter3>[A-Za-z])]\\|$";

        Pattern pattern = Pattern.compile(regex);
        int n = Integer.parseInt(scan.nextLine());


        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            Matcher matcher = pattern.matcher(input);
            List<Integer> characterList = new LinkedList<>();

            if (matcher.find()) {
                characterList.add((int) matcher.group("letter1").charAt(0));
                characterList.add((int) matcher.group("letter2").charAt(0));
                characterList.add((int) matcher.group("letter3").charAt(0));
                System.out.printf("%s: ", matcher.group("tag"));
                for (Integer integer : characterList) {
                    System.out.printf("%d ", integer);
                }
                System.out.println();
            } else {
                System.out.println("Valid message not found!");
            }
        }

    }
}
