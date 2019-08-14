package Q_Exams.Exam11August2019.viceCity.models.players;

import Q_Exams.Exam11August2019.viceCity.models.guns.Gun;
import Q_Exams.Exam11August2019.viceCity.repositories.interfaces.Repository;

public interface Player {
    String getName();

    int getLifePoints();

    boolean isAlive();

    Repository<Gun> getGunRepository();

    void takeLifePoints(int points);
}
