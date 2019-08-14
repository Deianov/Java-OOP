package Q_Exams.Exam11August2019.ViceCity_AuthorsSolution.core.interfaces;

public interface Controller {
    String addPlayer(String name);

    String addGun(String type, String name);

    String addGunToPlayer(String name);

    String fight();
}
