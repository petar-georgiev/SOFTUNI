package E03WildFarm.animals;

import java.text.DecimalFormat;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalName, String animalType, Double animalWeigh, String livingRegion, String breed) {
        super(animalName, animalType, animalWeigh, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %s, %d]%n",
                super.getAnimalType(),
                super.getAnimalName(),
                this.breed,
                new DecimalFormat("#.##").format(super.getAnimalWeigh()),
                super.getLivingRegion(),
                super.getFoodEaten());
    }
}
