package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardGames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> firstPersonCards = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> secondPersonCards = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());


        while (!(firstPersonCards.isEmpty() || secondPersonCards.isEmpty())) {
            int firstCard = firstPersonCards.get(0);
            int secondCard = secondPersonCards.get(0);

            if (firstCard > secondCard) {
                firstPersonCards.add(firstCard);
                firstPersonCards.add(secondCard);
            } else if (firstCard < secondCard) {
                secondPersonCards.add(secondCard);
                secondPersonCards.add(firstCard);

            }
            firstPersonCards.remove(0);
            secondPersonCards.remove(0);
        }
        int sum = 0;
        if (!firstPersonCards.isEmpty()) {
            for (Integer cards : firstPersonCards) {
                sum += cards;
            }
            System.out.printf("First player wins! Sum: %d", sum);
        } else {
            for (Integer cards : secondPersonCards) {
                sum += cards;
            }
            System.out.printf("Second player wins! Sum: %d", sum);
        }
    }
}
