package viceCity.core;

import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.Map;

import static viceCity.common.ConstantMessages.*;

public class ControllerImp implements Controller {
    private Player mainPlayer;
    private Map<String, Player> players;
    private Deque<Gun> guns;
    private Neighbourhood neighbourhood;

    public ControllerImp() {
        this.mainPlayer = new MainPlayer();
        this.players = new LinkedHashMap<>();
        this.guns = new ArrayDeque<>();
        this.neighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        players.put(name, new CivilPlayer(name));
        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun;
        switch (type) {
            case "Rifle":
                gun = new Rifle(name);
                break;
            case "Pistol":
                gun = new Pistol(name);
                break;
            default:
                return GUN_TYPE_INVALID;
        }
        guns.offer(gun);
        return String.format(GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {
        Gun gun = guns.poll();
        if (gun == null) {
            return GUN_QUEUE_IS_EMPTY;
        }
        if (name.equals(mainPlayer.getName().split("\\s+")[1])) {
            mainPlayer.getGunRepository().add(gun);
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), mainPlayer.getName());
        }

        Player player = players.get(name);

        if (player == null) {
            return CIVIL_PLAYER_DOES_NOT_EXIST;
        }

        player.getGunRepository().add(gun);

        return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), player.getName());

    }

    @Override
    public String fight() {
        neighbourhood.action(mainPlayer, players.values());

        if (mainPlayer.getLifePoints() == 100 && players.values()
                .stream().allMatch(s -> s.getLifePoints() == 50)) {
            return FIGHT_HOT_HAPPENED;
        }

        long alivePlayers = players.values()
                .stream()
                .filter(Player::isAlive)
                .count();

        StringBuilder out = new StringBuilder(FIGHT_HAPPENED);
        out.append(System.lineSeparator())
                .append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPlayer.getLifePoints()))
                .append(System.lineSeparator())
                .append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, players.size() - alivePlayers))
                .append(System.lineSeparator())
                .append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE, alivePlayers));

        return out.toString().trim();
    }
}
