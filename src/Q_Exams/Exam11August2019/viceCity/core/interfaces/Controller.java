package Q_Exams.Exam11August2019.viceCity.core.interfaces;

public interface Controller {
    String addPlayer(String name);

    String addGun(String type, String name);

    String addGunToPlayer(String name);

    String fight();
}
