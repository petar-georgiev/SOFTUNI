package StacksAndQueues≈xercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] tokens = scan.nextLine().split("\\s+");
        int n = Integer.parseInt(tokens[0]);
        int s = Integer.parseInt(tokens[1]);
        int x = Integer.parseInt(tokens[2]);

        ArrayDeque<Integer> stackNumbers = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(stackNumbers::push);

        for (int i = 0; i < s; i++) {
            stackNumbers.poll();
        }
        if (stackNumbers.contains(x))
            System.out.println(true);
        else if (stackNumbers.isEmpty())
            System.out.println(0);
        else
            System.out.println(stackNumbers.stream().min(Integer::compare).get());
        System.out.println();
    }
}
