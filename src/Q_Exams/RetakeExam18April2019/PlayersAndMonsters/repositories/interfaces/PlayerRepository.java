package Q_Exams.RetakeExam18April2019.PlayersAndMonsters.repositories.interfaces;

import Q_Exams.RetakeExam18April2019.PlayersAndMonsters.models.players.interfaces.Player;

import java.util.List;

public interface PlayerRepository {
    int getCount();

    List<Player> getPlayers();

    void add(Player player);

    boolean remove(Player player);

    Player find(String name);
}
