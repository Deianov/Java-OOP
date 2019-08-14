package Q_Exams.Exam11August2019.ViceCity_AuthorsSolution.models.players;

import Q_Exams.Exam11August2019.ViceCity_AuthorsSolution.models.guns.Gun;
import Q_Exams.Exam11August2019.ViceCity_AuthorsSolution.repositories.interfaces.Repository;

public interface Player {
    String getName();

    int getLifePoints();

    boolean isAlive();

    Repository<Gun> getGunRepository();

    void takeLifePoints(int points);
}
