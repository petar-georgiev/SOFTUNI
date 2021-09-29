package IteratorsAndComparatorsExercises.P01_ListyIterator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> data = Arrays.stream(scan.nextLine().split("\\s+"))
                .skip(1).collect(Collectors.toList());

        ListyIterator listyIterator = new ListyIterator(data);


        String input = scan.nextLine();

        while (!input.equals("END")) {
            switch (input) {
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    try {
                        System.out.println(listyIterator.print());
                    } catch (IllegalStateException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
            }
            input = scan.nextLine();
        }
    }
}
