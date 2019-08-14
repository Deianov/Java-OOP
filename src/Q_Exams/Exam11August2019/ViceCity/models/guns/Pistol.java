package Q_Exams.Exam11August2019.ViceCity.models.guns;

public class Pistol extends BaseGun {
    private static final int BULLETS_PER_BARREL = 10;
    private static final int TOTAL_BULLETS = 100;
    private static final int BULLETS_PER_SHOOT = 1;

    public Pistol(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
        super.setBulletsPerShoot(BULLETS_PER_SHOOT);
    }
}
