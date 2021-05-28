package RegularExpressionsExercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String regex = "%(?<name>[A-Z][a-z]+)%[^|$%.]*" +
                "<(?<product>\\w+)>[^|$%.]*" +
                "\\|(?<count>\\d+|)\\|[^|$%.]*?" +
                "(?<price>\\d+\\.?\\d+)\\$";
        Pattern pattern = Pattern.compile(regex);
        Double totalIncome = 0.0;
        String input = scan.nextLine();
        double totalPrice = 0.0;
        while (!input.equals("end of shift")) {
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                String name = matcher.group("name");
                String product = matcher.group("product");

                int count = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));
                totalPrice = count * price;
                System.out.printf("%s: %s - %.2f%n", name, product, totalPrice);

            }

            totalIncome += totalPrice;


            input = scan.nextLine();
        }
        System.out.printf("Total income: %.2f", totalIncome);
    }
}
