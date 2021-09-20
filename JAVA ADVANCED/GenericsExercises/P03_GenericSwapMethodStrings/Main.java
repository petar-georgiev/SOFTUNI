package GenericsExercises.P03_GenericSwapMethodStrings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        List<Box<String>> boxes = new ArrayList<>();

        while (n-- > 0) {
            String str = scan.nextLine();
            Box<String> box = new Box<>(str);
            boxes.add(box);
        }
        int firstIndex = scan.nextInt();
        int secondIndex = scan.nextInt();
        swapElements(boxes, firstIndex, secondIndex);
        for (Box<String> box : boxes) {
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
