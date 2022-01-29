package E06Animals;

public class Cat extends Animal{
    public Cat(String name, int age, Gender gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "meow meow";
    }
}
