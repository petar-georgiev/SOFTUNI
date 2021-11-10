package E03CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String rankPower = scan.nextLine();
        String suitPower = scan.nextLine();

        CardPower cardPower = new CardPower(RankPowers.valueOf(rankPower),
                SuitPowers.valueOf(suitPower));
        System.out.printf("Card name: %s of %s; Card power: %d",
                cardPower.getRankPowers().name(), cardPower.getSuitPowers().name(), cardPower.getPower());
    }
}
