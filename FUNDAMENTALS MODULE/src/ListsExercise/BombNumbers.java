package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String[] bombInfo = scan.nextLine().split(" ");
        int bombNumber = Integer.parseInt(bombInfo[0]);
        int bombPower = Integer.parseInt(bombInfo[1]);
        int bombIndex = numbers.indexOf(bombNumber);

        while (numbers.contains(bombNumber)) {

            int leftBoarder = Math.max(0, bombIndex - bombPower);
            int rightBoarder = Math.min(bombIndex + bombPower, numbers.size() - 1);

            for (int i = rightBoarder; i >= leftBoarder; i--) {
                numbers.remove(i);
            }
        }
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        System.out.println(sum);
    }
}
