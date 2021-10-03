package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_Bombs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> effects = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt).forEach(effects::offer);

        ArrayDeque<Integer> casing = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt).forEach(casing::push);

        int daturaBombs = 40;
        int cherryBombs = 60;
        int smokeDecoyBombs = 120;

        int daturaCounter = 0;
        int cherryCounter = 0;
        int smokeDecoyCounter = 0;

        while (!(casing.isEmpty() || effects.isEmpty())) {
            int sum = casing.peek() + effects.peek();

            if (sum == daturaBombs) {
                effects.poll();
                casing.pop();
                daturaCounter++;
            } else if (sum == cherryBombs) {
                effects.poll();
                casing.pop();
                cherryCounter++;
            } else if (sum == smokeDecoyBombs) {
                effects.poll();
                casing.pop();
                smokeDecoyCounter++;
            } else {
                casing.push(casing.pop() - 5);
            }
            if (daturaCounter >= 3 && cherryCounter >= 3 && smokeDecoyCounter >= 3) {
                System.out.println("Bene! You have successfully filled the bomb pouch!");
                printResult(effects, casing, cherryCounter, daturaCounter, smokeDecoyCounter);
                return;
            }
        }
        System.out.println("You don't have enough materials to fill the bomb pouch.");
        printResult(effects, casing, cherryCounter, daturaCounter, smokeDecoyCounter);
    }

    private static void printResult(ArrayDeque<Integer> effects, ArrayDeque<Integer> casing, int cherryCounter, int daturaCounter, int smokeDecoyCounter) {
        System.out.println(effects.isEmpty()
                ? "Bomb Effects: empty"
                : "Bomb Effects: " + effects.stream().map(String::valueOf)
                .collect(Collectors.joining(", ")));
        System.out.println(effects.isEmpty()
                ? "Bomb Casings: empty"
                : "Bomb Casings: " + casing.stream().map(String::valueOf)
                .collect(Collectors.joining(", ")));

        System.out.println("Cherry Bombs: " + cherryCounter);
        System.out.println("Datura Bombs: " + daturaCounter);
        System.out.println("Smoke Decoy Bombs: " + smokeDecoyCounter);
    }
}
