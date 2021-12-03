package E04PizzaCalories;

import E04PizzaCalories.Types.ToppingType;

public class Topping {
    private ToppingType toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        try {
            this.toppingType = ToppingType.valueOf(toppingType.toUpperCase());
        } catch (Exception ex) {
            throw new IllegalArgumentException(
                    String.format("Cannot place %s on top of your pizza.", toppingType));
        }
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(
                    String.format("%s weight should be in the range [1..50]", this.toppingType.name()));
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return 2 * this.weight * toppingType.getModifier();
    }
}
