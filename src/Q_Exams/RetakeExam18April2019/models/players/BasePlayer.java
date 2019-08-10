package Q_Exams.RetakeExam18April2019.models.players;

import Q_Exams.RetakeExam18April2019.common.ConstantMessages;
import Q_Exams.RetakeExam18April2019.models.players.interfaces.Player;
import Q_Exams.RetakeExam18April2019.repositories.interfaces.CardRepository;

public abstract class BasePlayer implements Player {
    private CardRepository cardRepository;
    private String username;
    private int health;

    protected BasePlayer(CardRepository cardRepository, String username, int health) {
        this.cardRepository = cardRepository;
        this.setUsername(username);
        this.setHealth(health);
    }

    @Override
    public CardRepository getCardRepository() {
        return this.cardRepository;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    private void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Player's username cannot be null or an empty string.");
        }
        this.username = username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public void setHealth(int healthPoints) {
        if (healthPoints < 0) {
            throw new IllegalArgumentException("Player's health bonus cannot be less than zero.");
        }
        this.health = healthPoints;
    }

    @Override
    public boolean isDead() {
        return this.health == 0;
    }

    @Override
    public void takeDamage(int damagePoints) {
        if (damagePoints < 0) {
            throw new IllegalArgumentException("Damage points cannot be less than zero.");
        }
        int newHealth = this.getHealth() - damagePoints;

        this.setHealth(newHealth < 0 ? 0 : newHealth);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
                .append(String.format(ConstantMessages.PLAYER_REPORT_INFO
                        , this.getUsername()
                        , this.getHealth()
                        , this.getCardRepository().getCount())
                )
                .append(System.lineSeparator());

        this.getCardRepository()
                .getCards()
                .forEach(c -> stringBuilder
                        .append(c.toString())
                        .append(System.lineSeparator())
                );

        stringBuilder
                .append(ConstantMessages.DEFAULT_REPORT_SEPARATOR);

        return stringBuilder.toString().trim();
    }
}
