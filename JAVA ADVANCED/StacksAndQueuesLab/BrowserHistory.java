package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();
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
            } else {
                if (currentURL != null) {
                    stack.push(currentURL);
                }
                currentURL = command;
            }
            System.out.println(currentURL);

            command = scan.nextLine();
        }
    }
}
