package L01Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException {
        Class <Reflection> clazz = Reflection.class;

        System.out.println(clazz);
        System.out.println(clazz.getSuperclass());
        for (Class<?> anInterface : clazz.getInterfaces()) {
            System.out.println(anInterface);
        }

        Constructor<Reflection> ctor = clazz.getDeclaredConstructor();

        Reflection reflection = ctor.newInstance();

        System.out.println(reflection);
    }
}
