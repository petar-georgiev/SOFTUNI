package E03WildFarm.animals;

import E03WildFarm.foods.Food;
import E03WildFarm.foods.Meat;

public class Zebra extends Mammal{

    public Zebra(String animalName, String animalType, Double animalWeigh, String livingRegion) {
        super(animalName, animalType, animalWeigh, livingRegion);
    }


    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
        if(food instanceof Meat){
            throw new IllegalArgumentException(
                    "Zebra are not eating that type of food!");
        }
        super.eat(food);
    }
}
