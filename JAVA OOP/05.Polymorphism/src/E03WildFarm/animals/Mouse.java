package E03WildFarm.animals;

import E03WildFarm.foods.Food;
import E03WildFarm.foods.Meat;

public class Mouse extends Mammal{
    public Mouse(String animalName, String animalType, Double animalWeigh, String livingRegion) {
        super(animalName, animalType, animalWeigh, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {
        if(food instanceof Meat){
            throw new IllegalArgumentException("Mouse are not eating that type of food!");
        }
        super.eat(food);
    }
}
