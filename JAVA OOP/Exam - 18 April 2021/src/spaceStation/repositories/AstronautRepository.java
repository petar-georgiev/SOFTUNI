package spaceStation.repositories;

import spaceStation.common.ConstantMessages;
import spaceStation.models.astronauts.Astronaut;

import java.util.ArrayList;
import java.util.List;

import static spaceStation.common.ConstantMessages.*;

public class AstronautRepository implements Repository<Astronaut> {

    private List<Astronaut> astronauts;

    public AstronautRepository() {
        this.astronauts = new ArrayList<>();
    }

    @Override
    public List<Astronaut> getModels() {
        return this.astronauts;
    }

    @Override
    public void add(Astronaut model) {
        astronauts.add(model);
    }

    @Override
    public boolean remove(Astronaut model) {
        return astronauts.remove(model);
    }

    @Override
    public Astronaut findByName(String name) {
        return this.astronauts.stream()
                .filter(f -> f.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Astronaut astronaut : astronauts) {
            sb.append(String.format(REPORT_ASTRONAUT_NAME, astronaut.getName()));
            sb.append(System.lineSeparator());
            sb.append(String.format(REPORT_ASTRONAUT_OXYGEN,astronaut.getOxygen()));
            sb.append(System.lineSeparator());
            String items = astronaut.getBag().getItems().isEmpty()
                    ? "none"
                    : String.join(REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER, astronaut.getBag().getItems());
            sb.append(String.format(REPORT_ASTRONAUT_BAG_ITEMS, items));
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
