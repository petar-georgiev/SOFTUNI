package GenericsLab.P01_JarOfT;

import java.util.ArrayDeque;
import java.util.List;

public class Jar<T> {

    private List<T> element;

    public void add(T element){
        this.element.add(element);
    }
    public T remove(){
        return this.element.remove(element.size()-1);
    }
}
