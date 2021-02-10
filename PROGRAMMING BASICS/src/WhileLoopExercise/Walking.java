package WhileLoopExercise;

import java.util.Scanner;

public class Walking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int steps = 10000;
        int value = Integer.parseInt(scan.nextLine());
        int sumSteps = 0;
        int remain = 0;
        sumSteps += value;
        String input = "";

        while (sumSteps <= steps) {
            input = scan.nextLine();
            if (input.equals("Going home")) {
                value = scan.nextInt();
                sumSteps += value;
                remain = sumSteps - steps;


            }
            value = Integer.parseInt(input);
            sumSteps += value;
            remain = sumSteps - steps;



        }
        if (input.equals("Going home")){
            System.out.println("Goal reached! Good job!");
            System.out.printf("%d more steps to reach goal", Math.abs(remain));
        }
        System.out.println("Goal reached! Good job!");
        System.out.printf("%d steps over the goal!", Math.abs(remain));
    }
}
