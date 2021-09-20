package GenericsExercises.P03_GenericSwapMethodStrings;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private T element;

    public Box(T element) {
        this.element = element;
    }
    @Override
    public String toString() {

        return String.format("%s: %s", this.element.getClass().getName(), element.toString());
    }
}
