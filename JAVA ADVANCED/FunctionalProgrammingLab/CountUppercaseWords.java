package FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> uppercaseWords = Arrays.stream(scan.nextLine().split("\\s+"))
                .filter(f -> Character.isUpperCase(f.charAt(0))).collect(Collectors.toList());

        System.out.println(uppercaseWords.size());
        uppercaseWords.forEach(System.out::println);


    }
}

