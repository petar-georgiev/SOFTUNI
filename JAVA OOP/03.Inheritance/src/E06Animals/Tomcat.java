package E06Animals;

public class Tomcat extends Cat{

    public Tomcat(String name, int age) {
        super(name, age, Gender.MALE);
    }

    @Override
    public String produceSound() {
        return "MEOW";
    }
}
