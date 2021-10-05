package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01_LootBox {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> first = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(first::offer);

        ArrayDeque<Integer> second = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(second::push);

        int sum = 0;
        while (!(first.isEmpty() || second.isEmpty())) {
            if ((first.peek() + second.peek()) % 2 == 0) {
                sum += first.pop() + second.poll();
            } else {
                first.offer(second.pop());
            }
        }
        String output = first.isEmpty()
                ? "First lootbox is empty"
                : "Second lootbox is empty";
        String output2 = sum >= 100
                ? String.format("Your loot was epic! Value: %d", sum)
                : String.format("Your loot was poor... Value: %d", sum);
        System.out.println(output + "\n" + output2);


    }
}

