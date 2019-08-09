package Q_Exams.DemoExam04August2019.motocrossWorldChampionship.entities.interfaces;

public interface Rider {
    String getName();

    Motorcycle getMotorcycle();

    int getNumberOfWins();

    void addMotorcycle(Motorcycle motorcycle);

    void winRace();

    boolean getCanParticipate();
}
