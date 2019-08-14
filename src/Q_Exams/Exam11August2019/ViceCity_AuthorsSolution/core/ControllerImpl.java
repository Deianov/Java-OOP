package Q_Exams.Exam11August2019.ViceCity_AuthorsSolution.core;

import Q_Exams.Exam11August2019.ViceCity_AuthorsSolution.core.interfaces.Controller;
import Q_Exams.Exam11August2019.ViceCity_AuthorsSolution.models.guns.Gun;
import Q_Exams.Exam11August2019.ViceCity_AuthorsSolution.models.guns.Pistol;
import Q_Exams.Exam11August2019.ViceCity_AuthorsSolution.models.guns.Rifle;
import Q_Exams.Exam11August2019.ViceCity_AuthorsSolution.models.neighbourhood.GangNeighbourhood;
import Q_Exams.Exam11August2019.ViceCity_AuthorsSolution.models.neighbourhood.Neighbourhood;
import Q_Exams.Exam11August2019.ViceCity_AuthorsSolution.models.players.CivilPlayer;
import Q_Exams.Exam11August2019.ViceCity_AuthorsSolution.models.players.MainPlayer;
import Q_Exams.Exam11August2019.ViceCity_AuthorsSolution.models.players.Player;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;

import static Q_Exams.Exam11August2019.ViceCity_AuthorsSolution.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private static final String MAIN_PLAYER_NAME = "Tommy Vercetti";
    private static final String MAIN_PLAYER_NAME_COMMAND = "Vercetti";
    private static final int MAIN_PLAYER_MAX_LIFE_POINTS = 100;
    private static final int CIVIL_PLAYERS_DEFAULT_DEAD_COUNT = 0;

    private Collection<Player> civilPlayers;
    private Player mainPlayer;
    private Neighbourhood neighbourhood;
    private Deque<Gun> guns;

    public ControllerImpl() {
        this.civilPlayers = new ArrayList<>();
        this.mainPlayer = new MainPlayer();
        this.guns = new ArrayDeque<>();

        this.neighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        Player player = new CivilPlayer(name);
        this.civilPlayers.add(player);

        String res = String.format(PLAYER_ADDED, name);
        return res;
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun = null;
        String res = null;

        if (Rifle.class.getSimpleName().equals(type)) {
            gun = new Rifle(name);
        } else if (Pistol.class.getSimpleName().equals(type)) {
            gun = new Pistol(name);
        }

        if (gun == null) {
            res = GUN_TYPE_INVALID;
        } else {
            res = String.format(GUN_ADDED, name, type);
            this.guns.offer(gun);
        }

        return res;
    }

    @Override
    public String addGunToPlayer(String name) {
        Gun gun = this.guns.peek();

        String message = null;
        if (gun == null) {
            return GUN_QUEUE_IS_EMPTY;
        }

        if (MAIN_PLAYER_NAME_COMMAND.equals(name)) {
            gun = this.guns.poll();
            this.mainPlayer.getGunRepository().add(gun);
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), MAIN_PLAYER_NAME);
        }

        Player civilPlayer = this.civilPlayers
                .stream()
                .filter(p -> p.getName().equals(name)).findFirst().orElse(null);

        if (civilPlayer == null) {
            return CIVIL_PLAYER_DOES_NOT_EXIST;
        }

        gun = this.guns.poll();
        civilPlayer.getGunRepository().add(gun);
        return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), civilPlayer.getName());
    }

    @Override
    public String fight() {
        this.neighbourhood.action(this.mainPlayer, this.civilPlayers);
        long deadCivilPlayers = this.civilPlayers
                .stream()
                .filter(p -> !p.isAlive())
                .count();

        StringBuilder sb = new StringBuilder();

        boolean areTakenLifePoints = this.civilPlayers.stream().allMatch(p -> p.getLifePoints() == 50);

        if (this.mainPlayer.getLifePoints() == MAIN_PLAYER_MAX_LIFE_POINTS && areTakenLifePoints) {
            sb.append(FIGHT_HOT_HAPPENED);
        } else {
            sb.append(FIGHT_HAPPENED)
                    .append(System.lineSeparator())
                    .append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE, this.mainPlayer.getLifePoints()))
                    .append(System.lineSeparator())
                    .append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, deadCivilPlayers))
                    .append(System.lineSeparator())
                    .append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE, this.civilPlayers.size() - deadCivilPlayers));
        }

        String res = sb.toString().trim();
        return res;
    }
}
