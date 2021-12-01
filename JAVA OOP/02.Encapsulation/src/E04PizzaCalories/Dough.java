package E04PizzaCalories;

import E04PizzaCalories.Types.BakingTechnique;
import E04PizzaCalories.Types.FlourType;

public class Dough {
    private FlourType flourType;
    private BakingTechnique bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    private void setFlourType(String flourType) {
        try {
            this.flourType = FlourType.valueOf(flourType.toUpperCase());
        } catch (Exception ex) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setBakingTechnique(String bakingTechnique) {
        try {
            this.bakingTechnique = BakingTechnique.valueOf(bakingTechnique.toUpperCase());
        } catch (Exception ex) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    public double calculateCalories() {
        return 2 * this.weight * this.flourType.getModifier()*this.bakingTechnique.getModifier();
    }

}
