package SetsAndMapsAdvancedLab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<String> carSet = new LinkedHashSet<>();

        String input = scan.nextLine();
        while (!input.equals("END")) {
            if (input.contains("IN")) {
                carSet.add(input.substring(input.indexOf(", ") + 2));
            } else if (input.contains("OUT")) {
                carSet.remove(input.substring(input.indexOf(", ") + 2));
            }
            input = scan.nextLine();
        }
        if (carSet.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            System.out.println(carSet.stream().collect(Collectors.joining(System.lineSeparator())));
        }
    }
}
