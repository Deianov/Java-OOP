package Q_Exams.RetakeExam18April2019.models.players.interfaces;

import Q_Exams.RetakeExam18April2019.repositories.interfaces.CardRepository;

public interface Player {
    CardRepository getCardRepository();

    String getUsername();

    int getHealth();

    void setHealth(int healthPoints);

    boolean isDead();

    void takeDamage(int damagePoints);
}
