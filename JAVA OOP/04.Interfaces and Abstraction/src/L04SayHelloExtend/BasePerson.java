package L04SayHelloExtend;

public abstract class BasePerson implements Person{

    private String name;

    public BasePerson(String name) {
        setName(name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public abstract String sayHello();

    private void setName(String name){
        this.name = name;
    }
}
