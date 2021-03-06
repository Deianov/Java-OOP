package Q_Exams.Exam11August2019.ViceCity_AuthorsSolution.models.players;

import Q_Exams.Exam11August2019.ViceCity_AuthorsSolution.models.guns.Gun;
import Q_Exams.Exam11August2019.ViceCity_AuthorsSolution.repositories.GunRepository;
import Q_Exams.Exam11August2019.ViceCity_AuthorsSolution.repositories.interfaces.Repository;

import static Q_Exams.Exam11August2019.ViceCity_AuthorsSolution.common.ExceptionMessages.*;

public abstract class BasePlayer implements Player {
    private static final int MIN_LIFE_POINTS = 0;

    private String name;
    private int lifePoints;
    private Repository<Gun> gunRepository;

    protected BasePlayer(String name, int lifePoints) {
        this.setName(name);
        this.setLifePoints(lifePoints);
        this.gunRepository = new GunRepository();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLifePoints() {
        return this.lifePoints;
    }

    @Override
    public boolean isAlive() {
        return this.getLifePoints() > MIN_LIFE_POINTS;
    }

    @Override
    public Repository<Gun> getGunRepository() {
        return this.gunRepository;
    }

    @Override
    public void takeLifePoints(int points) {
        if (this.getLifePoints() - points >= MIN_LIFE_POINTS) {
            this.setLifePoints(this.getLifePoints() - points);
        } else {
            this.setLifePoints(MIN_LIFE_POINTS);
        }
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(PLAYER_NULL_USERNAME);
        }
        this.name = name;
    }

    private void setLifePoints(int lifePoints) {
        if (lifePoints < MIN_LIFE_POINTS) {
            throw new IllegalArgumentException(PLAYER_LIFE_POINTS_LESS_THAN_ZERO);
        }

        this.lifePoints = lifePoints;
    }
}
