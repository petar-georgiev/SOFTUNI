package RegularExpressionsExercise;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String regex = ">>(?<furniture>\\w+)<<(?<price>\\d+(\\.\\d*)?)\\!(?<quantity>\\d+)";
        String input = scan.nextLine();
        double sum = 0.0;

        Pattern pattern = Pattern.compile(regex);
        System.out.println("Bought furniture:");

        while (!input.equals("Purchase")) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                System.out.println(matcher.group("furniture"));
                sum += (Double.parseDouble(matcher.group("price")) *
                        (Integer.parseInt(matcher.group("quantity"))));
            }

            input = scan.nextLine();
        }
        System.out.printf("Total money spend: %.2f", sum);
    }
}
