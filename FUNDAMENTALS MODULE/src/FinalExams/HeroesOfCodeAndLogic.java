package FinalExams;

import java.util.*;

public class HeroesOfCodeAndLogic {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<Integer>> heroList = new TreeMap<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            String name = tokens[0];
            int hitPoints = Integer.parseInt(tokens[1]);
            int manaPoints = Integer.parseInt(tokens[2]);

            heroList.putIfAbsent(name, new LinkedList<>());
            heroList.get(name).add(hitPoints);
            heroList.get(name).add(manaPoints);

        }
        String input = scan.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split(" - ");

            switch (tokens[0]) {
                case "CastSpell":
                    String heroName = tokens[1];
                    int MP = Integer.parseInt(tokens[2]);
                    String spellName = tokens[3];
                    if ((heroList.get(heroName).get(1) > MP) &&
                            (heroList.get(heroName).get(1) > 0)) {

                        int diff = heroList.get(heroName).get(1) - MP;
                        heroList.get(heroName).set(1, diff);
                        System.out.printf("%s has successfully cast " +
                                "%s and now has %d MP!%n", heroName, spellName, heroList.get(heroName).get(1));
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                    }
                    break;
                case "TakeDamage":
                    heroName = tokens[1];
                    int damage = Integer.parseInt(tokens[2]);
                    String attacker = tokens[3];
                    if ((heroList.get(heroName).get(0) > damage) &&
                            (heroList.get(heroName).get(0) > 0)) {
                        int diff = heroList.get(heroName).get(0) - damage;
                        heroList.get(heroName).set(0, diff);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",
                                heroName, damage, attacker, heroList.get(heroName).get(0));
                    } else {
                        heroList.remove(heroName);
                        System.out.printf("%s has been killed by %s!%n",
                                heroName, attacker);
                    }
                    break;
                case "Recharge":
                    heroName = tokens[1];
                    int amount = Integer.parseInt(tokens[2]);
                    if (amount + heroList.get(heroName).get(1) > 200) {
                        System.out.printf("%s recharged for %d MP!%n",
                                heroName, 200 - (heroList.get(heroName).get(1)));
                        heroList.get(heroName).set(1, 200);
                    } else {
                        heroList.get(heroName).set(1, amount + heroList.get(heroName).get(1));
                        System.out.printf("%s recharged for %d MP!%n", heroName, amount);
                    }
                    break;
                case "Heal":
                    heroName = tokens[1];
                    amount = Integer.parseInt(tokens[2]);
                    if (amount + heroList.get(heroName).get(0) > 100) {
                        System.out.printf("%s healed for %d HP!%n",
                                heroName, 100 - (heroList.get(heroName).get(0)));
                        heroList.get(heroName).set(0, 100);
                    } else {
                        heroList.get(heroName).set(0, amount + heroList.get(heroName).get(0));
                        System.out.printf("%s healed for %d HP!%n", heroName, amount);
                    }
                    break;
            }
            input = scan.nextLine();
        }
        heroList.entrySet().stream()
                .sorted((s1, s2) -> s2.getValue().get(0).compareTo(s1.getValue().get(0)))
                .forEach(s -> System.out.printf("%s%n  HP: %d%n  MP: %d%n",
                        s.getKey(), s.getValue().get(0), s.getValue().get(1)));
    }
}
