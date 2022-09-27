package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.bags.Backpack;
import spaceStation.models.bags.Bag;
import spaceStation.models.planets.Planet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MissionImpl implements Mission {
    private List<Astronaut> deadAstronaut;

    public MissionImpl() {
        this.deadAstronaut = new ArrayList<>();
    }

    public int getDeadAstronautSize() {
        return this.deadAstronaut.size();
    }

    @Override
    public void explore(Planet planet, List<Astronaut> astronauts) {

        for (Astronaut astronaut : astronauts) {
            for (int i = 0; i < planet.getItems().size(); i++) {
                if (astronaut.canBreath()) {
                    astronaut.getBag().getItems().add(planet.getItems().get(i));
                    astronaut.breath();
                    planet.getItems().remove(planet.getItems().get(i));
                    i--;
                    if (planet.getItems().isEmpty()) {
                        break;
                    }
                } else {
                    deadAstronaut.add(astronaut);
                    break;
                }
            }
        }
    }
}
