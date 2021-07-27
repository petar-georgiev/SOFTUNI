package SetsAndMapsAdvancedLab;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<Double, Integer> numbersMap = new LinkedHashMap<>();

        List<Double> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Double::parseDouble).collect(Collectors.toList());

        for (Double number : numbers) {
            numbersMap.putIfAbsent(number, 0);
            numbersMap.put(number, numbersMap.get(number) + 1);
        }
        for (Map.Entry<Double, Integer> entry : numbersMap.entrySet()) {
            System.out.printf("%.1f -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
