package Q_Exams.RetakeExam18April2019.PlayersAndMonsters.core;

import Q_Exams.RetakeExam18April2019.PlayersAndMonsters.common.ConstantMessages;
import Q_Exams.RetakeExam18April2019.PlayersAndMonsters.core.interfaces.ManagerController;
import Q_Exams.RetakeExam18April2019.PlayersAndMonsters.models.battleFields.BattleFieldImpl;
import Q_Exams.RetakeExam18April2019.PlayersAndMonsters.models.battleFields.interfaces.Battlefield;
import Q_Exams.RetakeExam18April2019.PlayersAndMonsters.models.cards.MagicCard;
import Q_Exams.RetakeExam18April2019.PlayersAndMonsters.models.cards.TrapCard;
import Q_Exams.RetakeExam18April2019.PlayersAndMonsters.models.cards.interfaces.Card;
import Q_Exams.RetakeExam18April2019.PlayersAndMonsters.models.players.Advanced;
import Q_Exams.RetakeExam18April2019.PlayersAndMonsters.models.players.Beginner;
import Q_Exams.RetakeExam18April2019.PlayersAndMonsters.models.players.interfaces.Player;
import Q_Exams.RetakeExam18April2019.PlayersAndMonsters.repositories.CardRepositoryImpl;
import Q_Exams.RetakeExam18April2019.PlayersAndMonsters.repositories.PlayerRepositoryImpl;
import Q_Exams.RetakeExam18April2019.PlayersAndMonsters.repositories.interfaces.CardRepository;
import Q_Exams.RetakeExam18April2019.PlayersAndMonsters.repositories.interfaces.PlayerRepository;


public class ManagerControllerImpl implements ManagerController {
    private static final String MAGIC_CARD_TYPE = "Magic";
    private static final String TRAP_CARD_TYPE = "Trap";
    private PlayerRepository playerRepository;
    private CardRepository cardRepository;
    private Battlefield battlefield;


    public ManagerControllerImpl() {
       this.playerRepository = new PlayerRepositoryImpl();
       this.cardRepository = new CardRepositoryImpl();
       this.battlefield = new BattleFieldImpl();
    }

    @Override
    public String addPlayer(String type, String username) {
        Player player = null;

        if (Beginner.class.getSimpleName().equals(type)){
            player = new Beginner(new CardRepositoryImpl(), username);

        } else if (Advanced.class.getSimpleName().equals(type)){
            player = new Advanced(new CardRepositoryImpl(), username);
        }
        this.playerRepository.add(player);

        String massage = String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER, type, username);
        return massage;
    }

    @Override
    public String addCard(String type, String name) {
        Card card = null;

        if(type.equals(MAGIC_CARD_TYPE)){
            card = new MagicCard(name);
        } else if (type.equals(TRAP_CARD_TYPE)) {
            card = new TrapCard(name);
        }
        this.cardRepository.add(card);
        String massage = String.format(ConstantMessages.SUCCESSFULLY_ADDED_CARD, type, name);
        return massage;
    }

    @Override
    public String addPlayerCard(String username, String cardName) {
        Player player = playerRepository.find(username);
        Card card = cardRepository.find(cardName);
        player.getCardRepository().add(card);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER_WITH_CARDS, cardName, username);
    }

    @Override
    public String fight(String attackUser, String enemyUser) {
        Player attackPlayer = playerRepository.find(attackUser);
        Player enemyPlayer = playerRepository.find(enemyUser);
        battlefield.fight(attackPlayer, enemyPlayer);
        return String.format(ConstantMessages.FIGHT_INFO, attackPlayer.getHealth(), enemyPlayer.getHealth());
    }

    @Override
    public String report() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Player player : this.playerRepository.getPlayers()) {
            stringBuilder
                    .append(player.toString())
                    .append(System.lineSeparator());
        }
        return  stringBuilder.toString().trim();
    }
}
