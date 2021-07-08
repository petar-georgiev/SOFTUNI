package StacksAndQueues≈xercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        ArrayDeque<Character> firstSide = new ArrayDeque<>();
        ArrayDeque<Character> secondSide = new ArrayDeque<>();

        for (int i = 0; i < input.length() / 2; i++) {
            if (input.contains("(") || input.contains("{") || input.contains("["))
                firstSide.push(input.charAt(i));
        }
        for (int i = input.length() / 2; i < input.length(); i++) {
            if (input.contains(")") || input.contains("}") || input.contains("]"))
                secondSide.offer(input.charAt(i));
        }
        boolean isBalanced = false;
        for (int i = 0; i < input.length() / 2; i++) {

            if ((firstSide.peek() == '(' && secondSide.peek() == ')') ||
                    (firstSide.peek() == '{' && secondSide.peek() == '}') ||
                    (firstSide.peek() == '[' && secondSide.peek() == ']') ||
                    (firstSide.peek() == ' ' && secondSide.peek() == ' ')) {
                isBalanced = true;
                continue;
            } else {
                System.out.println("NO");
                return;
            }
        }
        if (isBalanced) {
            System.out.println("YES");
        }
        if(firstSide.isEmpty()||secondSide.isEmpty())
            System.out.println("NO");
    }
}
