package MapsLambdaStreamAPILab;

import java.util.Arrays;
import java.util.Scanner;

public class WordFilter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Arrays.stream(scan.nextLine().split(" "))
                .filter(i -> i.length() % 2 == 0)
                .forEach(System.out::println);
    }
}
