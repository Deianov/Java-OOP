package Q_Exams.RetakeExam18April2019.PlayersAndMonsters.models.battleFields;

import Q_Exams.RetakeExam18April2019.PlayersAndMonsters.models.battleFields.interfaces.Battlefield;
import Q_Exams.RetakeExam18April2019.PlayersAndMonsters.models.cards.interfaces.Card;
import Q_Exams.RetakeExam18April2019.PlayersAndMonsters.models.players.Beginner;
import Q_Exams.RetakeExam18April2019.PlayersAndMonsters.models.players.interfaces.Player;


public class BattleFieldImpl implements Battlefield {
    private static final int BEGINNER_INCREASE_HEALTH = 40;
    private static final int BEGINNER_INCREASE_CARDS_DAMAGE = 30;

    @Override
    public void fight(Player attackPlayer, Player enemyPlayer) {

        if (attackPlayer.isDead() || enemyPlayer.isDead()){
            throw new IllegalArgumentException("Player is dead!");
        }

        fightPreparation(attackPlayer);
        fightPreparation(enemyPlayer);

        int attackerDamage = this.getCardsDamageSum(attackPlayer);
        int enemyDamage = this.getCardsDamageSum(enemyPlayer);


        while (!attackPlayer.isDead() && !enemyPlayer.isDead()){

            enemyPlayer.takeDamage(attackerDamage);

            if (!enemyPlayer.isDead()){
                attackPlayer.takeDamage(enemyDamage);
            }
        }
    }

    private int getCardsDamageSum(Player player){
        return player.getCardRepository().getCards().stream()
                .mapToInt(Card::getDamagePoints)
                .sum();
    }

    private void fightPreparation(Player player){

        // Beginner bonus
        if (player instanceof Beginner){
            player.setHealth(player.getHealth() + BEGINNER_INCREASE_HEALTH);

            for (Card card: player.getCardRepository().getCards()) {
                card.setDamagePoints(card.getDamagePoints() + BEGINNER_INCREASE_CARDS_DAMAGE);
            }
        }

        int cardsHealthSum = player.getCardRepository().getCards().stream()
                .mapToInt(Card::getHealthPoints)
                .sum();

        // get health points from deck
        player.setHealth(player.getHealth() + cardsHealthSum);
    }
}
