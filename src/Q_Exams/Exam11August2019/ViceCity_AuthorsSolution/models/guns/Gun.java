package Q_Exams.Exam11August2019.ViceCity_AuthorsSolution.models.guns;

public interface Gun {
    String getName();

    int getBulletsPerBarrel();

    boolean canFire();

    int getTotalBullets();

    int fire();
}
