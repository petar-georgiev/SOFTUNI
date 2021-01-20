package conditionalStatementsExercise;

import java.util.Scanner;

public class MetricConverter {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        double inputValue = Double.parseDouble(scan.nextLine());

        String inputDimension = scan.nextLine();
        String outputDimension = scan.nextLine();

        if (inputDimension.equals("mm")) {
            inputValue /= 1000;
        }
        if (inputDimension.equals("cm")) {
            inputValue /= 100;
        }
        if (inputDimension.equals("m")) {
            inputValue /= 1;
        }
        if (outputDimension.equals("mm")) {
            inputValue *= 1000;
        }
        if (outputDimension.equals("cm")) {
            inputValue *= 100;
        }
        if (outputDimension.equals("m")) {
            inputValue *= 1;
        }
        System.out.printf("%.3f", inputValue);
    }
}

