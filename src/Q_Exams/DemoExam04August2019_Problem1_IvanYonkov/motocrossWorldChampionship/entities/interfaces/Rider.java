package Q_Exams.DemoExam04August2019_Problem1_IvanYonkov.motocrossWorldChampionship.entities.interfaces;

public interface Rider {
    String getName();

    Motorcycle getMotorcycle();

    int getNumberOfWins();

    void addMotorcycle(Motorcycle motorcycle);

    void winRace();

    boolean getCanParticipate();
}
