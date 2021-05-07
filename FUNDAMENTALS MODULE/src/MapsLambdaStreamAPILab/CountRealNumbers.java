package MapsLambdaStreamAPILab;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<Double, Integer> numberOccurences = new TreeMap<>();

        String[] line = scan.nextLine().split(" ");

        for (int i = 0; i < line.length; i++) {
            double number = Double.parseDouble(line[i]);

            Integer occurences = numberOccurences.get(number);
            if (occurences == null) {
                occurences = 0;
            }
            numberOccurences.put(number, occurences + 1);

        }

        for (Map.Entry<Double, Integer> entry : numberOccurences.entrySet()) {
            DecimalFormat df = new DecimalFormat("#.#####");
            System.out.printf("%s -> %d%n", df.format(entry.getKey()), entry.getValue());
        }
    }
}
