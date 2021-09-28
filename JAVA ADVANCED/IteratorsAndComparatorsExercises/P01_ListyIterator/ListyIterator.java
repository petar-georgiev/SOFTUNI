package IteratorsAndComparatorsExercises.P01_ListyIterator;

import java.util.List;

public class ListyIterator {
    private List<String> data;
    private int index;

    public ListyIterator(List<String> data) {
        this.data = data;
        this.index = 0;
    }

    public boolean move() {
        if (this.hasNext()) {
            index++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return index < data.size() - 1;
    }

    public String print() throws IllegalStateException {
        if (this.data.isEmpty()) {
            throw new IllegalStateException("Invalid Operation!");
        }
        return this.data.get(this.index);
    }
}
