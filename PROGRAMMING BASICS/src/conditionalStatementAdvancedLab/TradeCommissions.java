package conditionalStatementAdvancedLab;

import java.util.Scanner;

public class TradeCommissions {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String town = scan.nextLine();
        double volumeOfSalles = Double.parseDouble(scan.nextLine());
        if (town.equals("Sofia")) {
            if (volumeOfSalles >= 0 && volumeOfSalles <= 500) {
                System.out.printf("%.2f", volumeOfSalles * 0.05);
            } else if (volumeOfSalles > 500 && volumeOfSalles <= 1000) {
                System.out.printf("%.2f", volumeOfSalles * 0.07);
            } else if (volumeOfSalles > 1000 && volumeOfSalles <= 10000) {
                System.out.printf("%.2f", volumeOfSalles * 0.08);
            } else if (volumeOfSalles > 10000) {
                System.out.printf("%.2f", volumeOfSalles * 0.12);
            }
            else {
                System.out.println("error");
            }
        }
        else if (town.equals("Varna")) {
            if (volumeOfSalles >= 0 && volumeOfSalles <= 500) {
                System.out.printf("%.2f", volumeOfSalles * 0.045);
            } else if (volumeOfSalles > 500 && volumeOfSalles <= 1000) {
                System.out.printf("%.2f", volumeOfSalles * 0.075);
            } else if (volumeOfSalles > 1000 && volumeOfSalles <= 10000) {
                System.out.printf("%.2f", volumeOfSalles * 0.1);
            } else if (volumeOfSalles > 10000) {
                System.out.printf("%.2f", volumeOfSalles * 0.13);
            }
            else {
                System.out.println("error");
            }
        }
        else if (town.equals("Plovdiv")) {
            if (volumeOfSalles >= 0 && volumeOfSalles <= 500) {
                System.out.printf("%.2f", volumeOfSalles * 0.055);
            } else if (volumeOfSalles > 500 && volumeOfSalles <= 1000) {
                System.out.printf("%.2f", volumeOfSalles * 0.08);
            } else if (volumeOfSalles > 1000 && volumeOfSalles <= 10000) {
                System.out.printf("%.2f", volumeOfSalles * 0.12);
            } else if (volumeOfSalles > 10000) {
                System.out.printf("%.2f", volumeOfSalles * 0.145);
            }
            else {
                System.out.println("error");
            }
        }
        else {
            System.out.println("error");
        }
    }
}
