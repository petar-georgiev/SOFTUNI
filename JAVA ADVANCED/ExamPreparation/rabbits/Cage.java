package rabbits;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Rabbit rabbit) {
        if (this.capacity > this.data.size()) {
            this.data.add(rabbit);
        }
    }

    public boolean removeRabbit(String name) {
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name)) {
                this.data.remove(i);
                return true;
            }
        }
        return false;
    }

    public void removeSpecies(String species) {
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getSpecies().equals(species)) {
                this.data.remove(i);
                i--;
            }
        }
    }

    public Rabbit sellRabbit(String name) {
        Rabbit rabbit = null;
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name)) {
                this.data.get(i).setAvailable(false);
                rabbit = this.data.get(i);
                break;
            }
        }
        return rabbit;
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        List<Rabbit> rabbitList = new ArrayList<>();
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getSpecies().equals(species)) {
                rabbitList.add(this.data.get(i));
                this.data.get(i).setAvailable(false);
            }
        }
        return rabbitList;
    }

    public int count() {
        return this.data.size();
    }
    public String report(){
StringBuilder sb =
        new StringBuilder(String.format("Rabbits available at %s:%n",this.name));
        for (Rabbit rabbit : this.data) {
            if(rabbit.isAvailable()){
                sb.append(rabbit);
                sb.append(System.lineSeparator());
            }
            System.out.println();
        }
        return sb.toString().trim();
    }
}
