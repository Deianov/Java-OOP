package Q_Exams.RetakeExam18April2019.PlayersAndMonsters.models.players;

import Q_Exams.RetakeExam18April2019.PlayersAndMonsters.repositories.interfaces.CardRepository;


public class Advanced extends BasePlayer {
    private static final int DEFAULT_HEALTH_POINTS = 250;

    public Advanced(CardRepository cardRepository, String username) {
        super(cardRepository, username, DEFAULT_HEALTH_POINTS);
    }
}
