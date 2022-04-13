package E03WildFarm.animals;

import E03WildFarm.foods.Food;

import java.text.DecimalFormat;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private Double animalWeigh;
    private int foodEaten;
    private String livingRegion;

    protected Animal(String animalName, String animalType, Double animalWeigh,String livingRegion) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeigh = animalWeigh;
        this.livingRegion = livingRegion;
    }

    public String getAnimalType() {
        return animalType;
    }

    public String getAnimalName() {
        return animalName;
    }

    public Double getAnimalWeigh() {
        return animalWeigh;
    }

    public int getFoodEaten() {
        return foodEaten;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    public abstract void makeSound();

    public void eat(Food food){
        this.foodEaten += food.getQuantity();
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %d]%n",
                this.animalType,
                this.animalName,
                new DecimalFormat("#.##").format(this.animalWeigh),
                this.livingRegion,
                this.foodEaten);
    }
}
