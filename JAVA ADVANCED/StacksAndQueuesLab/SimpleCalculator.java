package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] tokens = scan.nextLine().split("\\s+");

        Collections.addAll(stack, tokens);

        while (stack.size() > 1) {
            int first = Integer.parseInt(stack.pop());
            String operation = stack.pop();
            int second = Integer.parseInt(stack.pop());

            switch (operation) {
                case "+":
                    stack.push(String.valueOf(first + second));
                    break;

                case "-":
                    stack.push(String.valueOf(first - second));
                    break;

            }
        }
        System.out.println(stack.pop());
    }
}
