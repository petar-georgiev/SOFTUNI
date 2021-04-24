package ListsMoreExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TakeSkipRope {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> input = Arrays.stream(scan.nextLine().split(""))
                .collect(Collectors.toList());
        List<Integer> numbers = new ArrayList<>();
        List<Character> nonNumbers = new ArrayList<>();
        List<Character> takeList = new ArrayList<>();
        List<Character> skipList = nonNumbers;
        List<Character> result = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            char element = input.get(i).charAt(0);
            if (Character.isDigit(element)) {
                numbers.add(Integer.parseInt(String.valueOf(element)));
            } else {
                nonNumbers.add(element);
            }
        }
//        for (int i = 0; i < numbers.size(); i++) {
//            if (i % 2 == 0) {
//                takeList.add(numbers.get(i));
//            } else {
//                skipList.add(numbers.get(i));
//            }
//        }
        for (int i = 0; i < numbers.size(); i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < numbers.get(i); j++) {
                   takeList.add(nonNumbers.get(j));
                }
            }else {
                for (int j = 0; j < numbers.get(i); j++) {
                    skipList.remove(nonNumbers.get(j));
                }
            }
        }
        for (Character character : result) {
            System.out.print(result);
        }

    }
}

