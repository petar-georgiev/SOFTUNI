package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();
        String command = scan.nextLine();
        String currentURL = null;

        while (!command.equals("Home")) {
            if (command.equals("back")) {
                if (stack.isEmpty()) {
                    System.out.println("no previous URLs");
                    command = scan.nextLine();
                    continue;
                } else {
                    currentURL = stack.pop();
                }
            } else if (command.equals("forward")) {
                if (queue.isEmpty()) {
                    System.out.println("no next URLs");
                    command = scan.nextLine();
                    continue;
                } else {
                    currentURL = queue.poll();
                }
            } else {
                if (currentURL != null) {
                    stack.push(currentURL);
                    queue.offer(command);
                }
                currentURL = command;
            }
            System.out.println(currentURL);

            command = scan.nextLine();
        }
    }
}
