package StacksAndQueues≈xercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> elements = new ArrayDeque<>();
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            switch (input.charAt(0)){
                case '1':
                    String[] tokens = input.split("\\s+");
                    int element = Integer.parseInt(tokens[1]);
                    elements.push(element);
                    break;
                case '2':
                    elements.pop();
                    break;
                case '3':
                    System.out.println(elements.stream().max(Integer::compare).get());
                    break;
            }
        }
    }
}
