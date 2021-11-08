package E02CardRank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String input = new Scanner(System.in).nextLine();
        System.out.println(input+":");
        for (CardRank cardRank: CardRank.values()){
            System.out.printf("Ordinal value: %d; Name value: %s%n",
                    cardRank.ordinal(), cardRank.name());
        }
    }
}
