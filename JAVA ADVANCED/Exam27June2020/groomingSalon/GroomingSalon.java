package groomingSalon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class GroomingSalon {
    private int capacity;
    private List<Pet> data;


    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        int age = pet.getAge();
        if (capacity > data.size() && age > 0) {
            this.data.add(pet);
        }

    }

    public boolean remove(String name) {
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name)) {
                this.data.remove(i);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        for (Pet pet : this.data) {
            if (pet.getName().equals(name) || pet.getOwner().equals(owner)) {
                return pet;
            }
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder("The grooming salon has the following clients:" +
                System.lineSeparator());
        for (Pet pet : data) {
            sb.append(pet + System.lineSeparator());
        }
        return sb.toString().trim();
        Comparable

    }
}
