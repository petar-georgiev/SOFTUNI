package ListsMoreExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DrumSet {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double savings = Double.parseDouble(scan.nextLine());
        List<Integer> sequence = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> sequenceSaved = new ArrayList<>(sequence);

        String input = scan.nextLine();
        while (!input.equalsIgnoreCase("Hit it again, Gabsy!")) {

            int power = Integer.parseInt(input);

            for (int i = 0; i < sequence.size(); i++) {
                sequence.set(i, sequence.get(i) - power);

                if (sequence.get(i) <= 0) {
                    sequence.set(i, sequenceSaved.get(i));
                    savings -= sequenceSaved.get(i) * 3;
                }

                if (savings <= 0) {
                    sequence.remove(i);
                    savings += sequenceSaved.get(i) * 3;
                    sequenceSaved.remove(i);
                    i--;
                }
            }
            input = scan.nextLine();
        }
        System.out.println(sequence.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        System.out.printf("Gabsy has %.2flv.", savings);
    }
}
