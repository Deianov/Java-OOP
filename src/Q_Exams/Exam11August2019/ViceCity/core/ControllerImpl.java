package Q_Exams.Exam11August2019.ViceCity.core;

import Q_Exams.Exam11August2019.ViceCity.common.ConstantMessages;
import Q_Exams.Exam11August2019.ViceCity.core.interfaces.Controller;
import Q_Exams.Exam11August2019.ViceCity.models.guns.Gun;
import Q_Exams.Exam11August2019.ViceCity.models.guns.Pistol;
import Q_Exams.Exam11August2019.ViceCity.models.guns.Rifle;
import Q_Exams.Exam11August2019.ViceCity.models.neighbourhood.GangNeighbourhood;
import Q_Exams.Exam11August2019.ViceCity.models.neighbourhood.Neighbourhood;
import Q_Exams.Exam11August2019.ViceCity.models.players.CivilPlayer;
import Q_Exams.Exam11August2019.ViceCity.models.players.MainPlayer;
import Q_Exams.Exam11August2019.ViceCity.models.players.Player;
import Q_Exams.Exam11August2019.ViceCity.repositories.GunRepository;
import Q_Exams.Exam11August2019.ViceCity.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ControllerImpl implements Controller {
    private static final String MAIN_PLAYER_LAST_NAME = "Vercetti";
    private static final int MAIN_PLAYER_MAX_POINTS = 100;
    private final Collection<Player> civilPlayers;
    private final Repository<Gun> gunRepository;
    private Player mainPlayer;
    private Neighbourhood gangNeighbourhood;

    public ControllerImpl() {
        this.civilPlayers = new ArrayList<>();
        this.gunRepository = new GunRepository();
        this.mainPlayer = new MainPlayer();
        this.gangNeighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        this.civilPlayers.add(new CivilPlayer(name));
        return String.format(ConstantMessages.PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun newGun = null;
        if (type.equals(Pistol.class.getSimpleName())) {
            newGun = new Pistol(name);
        } else if (type.equals(Rifle.class.getSimpleName())) {
            newGun = new Rifle(name);
        }
        String result;
        if (newGun == null) {
            result = ConstantMessages.GUN_TYPE_INVALID;
        } else {
            this.gunRepository.add(newGun);
            result = String.format(ConstantMessages.GUN_ADDED, name, type);
        }
        return result;
    }

    @Override
    public String addGunToPlayer(String name) {
        String result = null;
        Iterator<Gun> gunIterator = this.gunRepository.getModels().iterator();

        if (!gunIterator.hasNext()) {
            result = ConstantMessages.GUN_QUEUE_IS_EMPTY;

        } else {
            Gun gun = gunIterator.next();

            boolean isMainPlayer = name.equals(MAIN_PLAYER_LAST_NAME);
            Player player;

            if (isMainPlayer) {
                player = this.mainPlayer;
            } else {
                player = this.civilPlayers.stream()
                        .filter(p -> p.getName().equals(name))
                        .findFirst()
                        .orElse(null);
            }
            if (player == null) {
                result = ConstantMessages.CIVIL_PLAYER_DOES_NOT_EXIST;
            } else {
                player.getGunRepository().add(gun);
                this.gunRepository.remove(gun);

                if (isMainPlayer) {
                    result = String.format(ConstantMessages.GUN_ADDED_TO_MAIN_PLAYER
                            , gun.getName(), player.getName());
                } else {
                    result = String.format(ConstantMessages.GUN_ADDED_TO_CIVIL_PLAYER
                            , gun.getName(), player.getName());
                }
            }
        }
        return result;
    }

    @Override
    public String fight() {
        int baseCivilPlayersCount = this.civilPlayers.size();

        this.gangNeighbourhood.action(this.mainPlayer, this.civilPlayers);
        this.civilPlayers.removeIf(player -> !player.isAlive());

        int mainPlayerPoint = this.mainPlayer.getLifePoints();
        int civilPlayersCount = this.civilPlayers.size();

        StringBuilder result = new StringBuilder();

        if (MAIN_PLAYER_MAX_POINTS == mainPlayerPoint &&
            baseCivilPlayersCount == civilPlayersCount) {
            result.append(ConstantMessages.FIGHT_HOT_HAPPENED);
        } else {
            result
                    .append(ConstantMessages.FIGHT_HAPPENED)
                    .append(System.lineSeparator())
                    .append(String.format(
                            ConstantMessages.MAIN_PLAYER_LIVE_POINTS_MESSAGE,
                            mainPlayerPoint))
                    .append(System.lineSeparator())
                    .append(String.format(
                            ConstantMessages.MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE,
                            baseCivilPlayersCount - civilPlayersCount))
                    .append(System.lineSeparator())
                    .append(String.format(ConstantMessages.CIVIL_PLAYERS_LEFT_MESSAGE, civilPlayersCount));
        }

        return result.toString();
    }
}
