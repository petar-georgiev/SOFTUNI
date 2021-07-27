package SetsAndMapsAdvancedLab;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Voina {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashSet<Integer> firstPlayer = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        LinkedHashSet<Integer> secondPlayer = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int counter = 50;
        while (counter-- >= 0 && !firstPlayer.isEmpty() && !secondPlayer.isEmpty()) {
            int topFirstElement = firstPlayer.iterator().next();
            int topSecondElement = secondPlayer.iterator().next();
            firstPlayer.remove(topFirstElement);
            secondPlayer.remove(topSecondElement);

            if (topFirstElement > topSecondElement) {
                firstPlayer.add(topFirstElement);
                firstPlayer.add(topSecondElement);
            } else if (topSecondElement > topFirstElement) {
                secondPlayer.add(topFirstElement);
                secondPlayer.add(topSecondElement);
            }
        }
        if (firstPlayer.size() == secondPlayer.size()) {
            System.out.println("Draw!");
        } else if (secondPlayer.size() < firstPlayer.size()) {
            System.out.println("First player win!");
        } else {
            System.out.println("Second player win!");
        }
    }
}
