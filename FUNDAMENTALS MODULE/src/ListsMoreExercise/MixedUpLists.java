package ListsMoreExercise;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MixedUpLists {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> firstSequence = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondSequence = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> mixList = new ArrayList<>();

        int lowerLimit = 0;
        int upperLimit = 0;

        if (firstSequence.size() > secondSequence.size()) {
            int[] limit = new int[]{(firstSequence.get(firstSequence.size() - 1)),
                    (firstSequence.get(firstSequence.size() - 2))};
            firstSequence.subList(firstSequence.size() - 2, firstSequence.size()).clear();
            lowerLimit = Arrays.stream(limit).min().getAsInt();
            upperLimit = Arrays.stream(limit).max().getAsInt();
        } else {
            int[] limit = new int[]{(secondSequence.get(secondSequence.size() - 1)),
                    (secondSequence.get(secondSequence.size() - 2))};
            secondSequence.subList(secondSequence.size() - 2, secondSequence.size()).clear();
            lowerLimit = Arrays.stream(limit).min().getAsInt();
            upperLimit = Arrays.stream(limit).max().getAsInt();
        }
        for (int i = 0, j = secondSequence.size() - 1; i < firstSequence.size() && j >= 0; i++, j--) {
            mixList.add(firstSequence.get(i));
            mixList.add(secondSequence.get(j));
        }
        int finalLowerLimit = lowerLimit;
        int finalUpperLimit = upperLimit;

        mixList.stream().filter(f -> f > finalLowerLimit && f < finalUpperLimit)
                .sorted(Comparator.naturalOrder()).forEach(s -> System.out.printf("%d ", s));

    }
}

