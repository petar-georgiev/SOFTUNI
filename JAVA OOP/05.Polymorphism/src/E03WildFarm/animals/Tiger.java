package E03WildFarm.animals;

import E03WildFarm.foods.Food;
import E03WildFarm.foods.Vegetable;

public class Tiger extends Felime{
    private String livingRegion;

    public Tiger(String animalName, String animalType, Double animalWeigh, String livingRegion) {
        super(animalName, animalType, animalWeigh, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if(food instanceof Vegetable){
            throw new IllegalArgumentException(
                    "Tigers are not eating that type of food!");
        }
        super.eat(food);
    }
}
