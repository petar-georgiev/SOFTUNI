package SetsAndMapsAdvancedLab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<String> vipSet = new TreeSet<>();
        Set<String> regularSet = new TreeSet<>();

        String input = scan.nextLine();
        while (!input.equalsIgnoreCase("party")) {

            if (Character.isDigit(input.charAt(0))) {
                vipSet.add(input);
            } else {
                regularSet.add(input);
            }
            input = scan.nextLine();
        }
        input = scan.nextLine();
        while (!input.equalsIgnoreCase("end")) {

            vipSet.remove(input);
            regularSet.remove(input);
            input = scan.nextLine();
        }
        System.out.println(vipSet.size() + regularSet.size());
        if (vipSet.isEmpty()) {
            System.out.println(regularSet.stream().collect(Collectors.joining(System.lineSeparator())));
        } else if (regularSet.isEmpty()) {
            System.out.println(vipSet.stream().collect(Collectors.joining(System.lineSeparator())));
        } else {
            System.out.println(vipSet.stream().collect(Collectors.joining(System.lineSeparator())));
            System.out.println(regularSet.stream().collect(Collectors.joining(System.lineSeparator())));
        }
    }
}
