package Q_Exams.Exam11August2019.viceCity.models.guns;

import Q_Exams.Exam11August2019.viceCity.common.ExceptionMessages;

public abstract class BaseGun implements Gun {
    private String name;
    private int bulletsPerBarrel;
    private int totalBullets;
    private int bulletsPerShoot;
    private int defaultBulletsPerBarrel;

    protected BaseGun(String name, int bulletsPerBarrel, int totalBullets) {
        this.setName(name);
        this.setBulletsPerBarrel(bulletsPerBarrel);
        this.setTotalBullets(totalBullets);
        this.defaultBulletsPerBarrel = bulletsPerBarrel;
    }

    protected void setBulletsPerShoot(int bulletsPerShoot) {
        this.bulletsPerShoot = bulletsPerShoot;
    }

    private void setName(String name) {
        if(name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.NAME_NULL);
        }
        this.name = name;
    }

    private void setBulletsPerBarrel(int bulletsPerBarrel) {
        if(bulletsPerBarrel < 0) {
            throw new IllegalCallerException(ExceptionMessages.BULLETS_LESS_THAN_ZERO);
        }
        this.bulletsPerBarrel = bulletsPerBarrel;
    }

    private void setTotalBullets(int totalBullets) {
        if(totalBullets < 0) {
            throw new IllegalArgumentException(ExceptionMessages.TOTAL_BULLETS_LESS_THAN_ZERO);
        }
        this.totalBullets = totalBullets;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getBulletsPerBarrel() {
        return this.bulletsPerBarrel;
    }

    @Override
    public boolean canFire() {
        if (this.getBulletsPerBarrel() < this.bulletsPerShoot) {
            if (this.getTotalBullets() >= this.defaultBulletsPerBarrel) {
                this.setBulletsPerBarrel(defaultBulletsPerBarrel);
                this.totalBullets -= defaultBulletsPerBarrel;
            }
            // TODO: 13.8.2019 else perShoot?
        }
        return this.getBulletsPerBarrel() >= this.bulletsPerShoot;
    }

    @Override
    public int getTotalBullets() {
        return this.totalBullets;
    }

    @Override
    public int fire() {
        if(this.canFire()) {
            this.bulletsPerBarrel -= this.bulletsPerShoot;
            return this.bulletsPerShoot;
        }
        return 0;
    }
}
