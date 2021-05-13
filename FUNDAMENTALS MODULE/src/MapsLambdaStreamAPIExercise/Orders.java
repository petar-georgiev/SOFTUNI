package MapsLambdaStreamAPIExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Double> priceMap = new LinkedHashMap<>();
        Map<String, Integer> quantityMap = new LinkedHashMap<>();

        String input = scan.nextLine();
        while (!input.equals("buy")) {

            String[] data = input.split("\\s+");
            String product = data[0];
            double price = Double.parseDouble(data[1]);
            int quantity = Integer.parseInt(data[2]);

            priceMap.put(product, price);
            quantityMap.putIfAbsent(product,0);
            int newQuantity = quantityMap.get(product) + quantity;
            quantityMap.put(product, newQuantity);

            input = scan.nextLine();
        }
        quantityMap.forEach((k, v) -> System.out.printf("%s -> %.2f%n", k, v * priceMap.get(k)));
    }
}

