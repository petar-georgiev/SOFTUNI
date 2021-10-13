package guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (this.capacity > this.roster.size()) {
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        for (int i = 0; i < this.roster.size(); i++) {
            if (this.roster.get(i).getName().equals(name)) {
                this.roster.remove(i);
                return true;
            }
        }
        return false;
    }

    public void promotePlayer(String name) {
        for (int i = 0; i < this.roster.size(); i++) {
            if (this.roster.get(i).getName().equals(name)) {
                if (!this.roster.get(i).getRank().equals("Member"))
                    this.roster.get(i).setRank("Member");
            }
        }

    }

    public void demotePlayer(String name) {
        for (int i = 0; i < this.roster.size(); i++) {
            if (this.roster.get(i).getName().equals(name)) {
                if (!this.roster.get(i).getRank().equals("Trial"))
                    this.roster.get(i).setRank("Trial");
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        Player[] players = this.roster.stream()
                .filter(f -> f.getClazz().equals(clazz))
                .toArray(Player[]::new);
        for (Player player : players) {
            this.roster.remove(player);
        }
        return players;
    }

    public int count() {
        return this.roster.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        System.out.println();
        sb.append(String.format("Players in the guild: %s:%n", this.name));
        for (Player player : roster) {
            sb.append(player.toString());
        }
        return sb.toString().trim();
    }
}