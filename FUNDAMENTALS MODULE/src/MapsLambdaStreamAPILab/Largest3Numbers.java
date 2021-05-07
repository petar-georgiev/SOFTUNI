package MapsLambdaStreamAPILab;

import java.util.Arrays;
import java.util.Scanner;

public class Largest3Numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(d -> Integer.parseInt(d))
                .sorted((d1, d2) -> Integer.compare(d2, d1))
                .limit(3)
                .forEach(d -> System.out.print(d+" "));
    }
}
