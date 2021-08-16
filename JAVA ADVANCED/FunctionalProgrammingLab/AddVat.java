package FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddVat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Double> doubleList = Arrays.stream(scan.nextLine().split(", "))
                .map(Double::parseDouble).map(s -> s + s * 0.2)
                .collect(Collectors.toList());
        System.out.println("Prices with VAT:");
        doubleList.forEach(s -> System.out.printf("%.2f%n", s));
    }
}
