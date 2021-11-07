package E01CardSuit;

import E02CardRank.CardRank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String input = new Scanner(System.in).nextLine();
        System.out.println(input + ":");
        for ( CardRank card:CardRank.values())

            System.out.printf("Ordinal value: %d; Name value: %s%n",
                    card.ordinal(),
                    card.name());
    }
}
