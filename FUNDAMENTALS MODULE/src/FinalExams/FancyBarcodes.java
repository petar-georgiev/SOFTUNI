package FinalExams;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String regex = "\\@\\#+(?<product>[A-Z][A-Za-z0-9]{4,}[A-Z])\\@\\#+";
        String digitRegex = "\\d+";

        Pattern pattern = Pattern.compile(regex);
        Pattern pattern1 = Pattern.compile(digitRegex);

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();

            String input = scan.nextLine();
            Matcher matcher = pattern.matcher(input);
            Matcher matcher1 = pattern1.matcher(input);

            if (matcher.find()) {
                while (matcher1.find()) {
                    sb.append(matcher1.group());
                }
                if (sb.length() == 0) {
                    System.out.println("Product group: 00");
                } else {
                    System.out.println("Product group: " + sb.toString());
                }
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}

