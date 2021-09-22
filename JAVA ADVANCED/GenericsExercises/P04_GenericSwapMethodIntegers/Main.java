package GenericsExercises.P04_GenericSwapMethodIntegers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        List<Box<Integer>> boxes = new ArrayList<>();

        while (n-- > 0) {
            int str = Integer.parseInt(scan.nextLine());
            Box<Integer> box = new Box<>(str);
            boxes.add(box);
        }
        int firstIndex = scan.nextInt();
        int secondIndex = scan.nextInt();
        swapElements(boxes, firstIndex, secondIndex);
        for (Box<Integer> box : boxes) {
            System.out.println(box.toString());
        }
    }

    private static <T> void swapElements(List<Box<T>> boxes,
                                         int firstIndex,
                                         int secondIndex) {
        Box temp = boxes.get(firstIndex);
        boxes.set(firstIndex, boxes.get(secondIndex));
        boxes.set(secondIndex, temp);
    }
}
