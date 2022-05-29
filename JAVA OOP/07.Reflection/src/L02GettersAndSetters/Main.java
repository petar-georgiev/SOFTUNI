package L02GettersAndSetters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Class<Reflection> clazz = Reflection.class;
        Method[] methods = clazz.getDeclaredMethods();

        Arrays.stream(methods).filter(method -> method.getName().startsWith("get"))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.println(
                        String.format("%s will return class %s",
                                method.getName(),
                                method.getReturnType().getName())
                ));

        Arrays.stream(methods)
                .filter(method -> method.getName().startsWith("set"))
                .filter(method -> method.getParameterTypes().length == 1)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.println(
                        String.format("%s and will set field of class %s",
                                method.getName(),
                                method.getParameterTypes()[0].getName())
                ));
    }
}
