package NestedLoopsExercise;

import java.util.Scanner;

public class TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String input = scan.nextLine();
        double sum = 0.0;
        double average = 0.0;
        int counter = 0;
        int counter2 = 0;
        double allSum = 0.0;
        double allAverage = 0.0;


        while (!input.equals("Finish")) {
            String presentation = input;

            for (int i = 0; i < n; i++) {
                double grade = Double.parseDouble(scan.nextLine());
                counter++;
                sum += grade;
                average = sum / counter;
                continue;

            }
            sum=0;
            counter=0;
            counter2++;
            allSum += average;
            allAverage = allSum/counter2;

            System.out.printf("%s - %.2f.%n", presentation, average);
            input = scan.nextLine();
        }
        System.out.printf("Student's final assessment is %.2f.", allAverage);
    }
}
