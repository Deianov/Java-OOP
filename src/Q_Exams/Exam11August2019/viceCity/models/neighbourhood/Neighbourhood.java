package Q_Exams.Exam11August2019.viceCity.models.neighbourhood;

import Q_Exams.Exam11August2019.viceCity.models.players.Player;

import java.util.Collection;

public interface Neighbourhood {
    void action(Player mainPlayer, Collection<Player> civilPlayers);
}
