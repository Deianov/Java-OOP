package Q_Exams.RetakeExam18April2019.PlayersAndMonsters.repositories;

import Q_Exams.RetakeExam18April2019.PlayersAndMonsters.models.players.interfaces.Player;
import Q_Exams.RetakeExam18April2019.PlayersAndMonsters.repositories.interfaces.PlayerRepository;

import java.util.*;

public class PlayerRepositoryImpl implements PlayerRepository {
    private Map<String, Player> players;

    public PlayerRepositoryImpl() {
        this.players = new LinkedHashMap<>();
    }

    @Override
    public int getCount() {
        return this.getPlayers().size();
    }

    @Override
    public List<Player> getPlayers() {
        return Collections.unmodifiableList(new ArrayList<>(this.players.values()));
    }

    @Override
    public void add(Player player) {
        if(player == null){
            throw new IllegalArgumentException("Player cannot be null");
        }
        if(players.containsKey(player.getUsername())){
            throw new IllegalArgumentException(String.format("Player %s already exists!", player.getUsername()));
        }
        this.players.put(player.getUsername(), player);
    }

    @Override
    public boolean remove(Player player) {
        if(player == null){
            throw new IllegalArgumentException("Player cannot be null");
        }
        if (this.players.containsKey(player.getUsername())){
            this.players.remove(player.getUsername());
            return true;
        }
        return false;
    }

    @Override
    public Player find(String name) {
        Player player = this.players.get(name);
        return player;
    }
}
