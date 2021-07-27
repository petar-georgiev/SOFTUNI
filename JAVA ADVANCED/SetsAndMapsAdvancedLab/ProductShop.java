package SetsAndMapsAdvancedLab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Map<String, Double>> shopMap = new TreeMap<>();
        String input = scan.nextLine();
        while (!input.equalsIgnoreCase("revision")) {

            String[] tokens = input.split(", ");
            String shopName = tokens[0];
            String product = tokens[1];
            Double price = Double.parseDouble(tokens[2]);

            shopMap.putIfAbsent(shopName, new LinkedHashMap<>());
            shopMap.get(shopName).put(product, price);

            input = scan.nextLine();
        }
        shopMap.entrySet().forEach((s) -> {
            String shopName = s.getKey();
            Map<String, Double> productAndPrice = s.getValue();
            System.out.println(shopName + "->");
            for (Map.Entry<String, Double> entry : productAndPrice.entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", entry.getKey(), entry.getValue());
            }
        });

    }
}
