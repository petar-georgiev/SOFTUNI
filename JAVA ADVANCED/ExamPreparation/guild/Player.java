package guild;

public class Player {
    private String name;
    private String clazz;
    private String rank;
    private String description;

    public Player(String name, String clazz) {
        this.name = name;
        this.clazz = clazz;
        this.rank = "Trial";
        this.description = "n/a";
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getClazz() {
        return clazz;
    }

    public String getRank() {
        return rank;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return String.format("Player %s: %s%n" +
                "Rank: %s%n" +
                "Description: %s%n",
                this.name,this.clazz,this.rank,this.description);
    }
}
