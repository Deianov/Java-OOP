package Q_Exams.RetakeExam18April2019.repositories.interfaces;

import Q_Exams.RetakeExam18April2019.models.players.interfaces.Player;

import java.util.List;

public interface PlayerRepository {
    int getCount();

    List<Player> getPlayers();

    void add(Player player);

    boolean remove(Player player);

    Player find(String name);
}
