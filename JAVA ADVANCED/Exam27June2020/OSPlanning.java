package Exam27June2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OSPlanning {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt).forEach(tasks::push);

        ArrayDeque<Integer> threads = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(threads::offer);

        int value = Integer.parseInt(scan.nextLine());

        while (tasks.peek() != value) {
            int currentTask = tasks.peek();
            int currentThreads = threads.poll();

            if (currentThreads >= currentTask) {
                tasks.pop();
            }

        }

        System.out.println(String.format("Thread with value %d killed task %d",
                threads.peek(), value));
        System.out.println(threads.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));

    }
}
