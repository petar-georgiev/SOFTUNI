package E03CardsWithPower;

public class CardPower {
    private RankPowers rankPowers;
    private SuitPowers suitPowers;

    public CardPower(RankPowers rankPowers, SuitPowers suitPowers) {
        this.rankPowers = rankPowers;
        this.suitPowers = suitPowers;
    }

    public int getPower() {
        return rankPowers.getValue() + suitPowers.getValue();
    }

    public RankPowers getRankPowers() {
        return rankPowers;
    }

    public SuitPowers getSuitPowers() {
        return suitPowers;
    }
}
