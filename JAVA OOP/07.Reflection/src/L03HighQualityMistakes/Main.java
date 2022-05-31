package L03HighQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Class<Reflection> clazz = Reflection.class;
        Method[] methods = clazz.getDeclaredMethods();

        Arrays.stream(clazz.getDeclaredFields())
                .filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(field -> System.out.println(
                        String.format("%s must be private!",
                                field.getName())
                ));

        Arrays.stream(methods).filter(method -> method.getName().startsWith("get"))
                .filter(method -> !Modifier.isPublic(method.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.println(
                        String.format("%s have to be public!",
                                method.getName())));

        Arrays.stream(methods)
                .filter(method -> method.getName().startsWith("set"))
                .filter(method -> method.getParameterTypes().length==1)
                .filter(method -> !Modifier.isPrivate(method.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.println(
                        String.format("%s have to be private!",
                                method.getName())
                ));
    }
}
