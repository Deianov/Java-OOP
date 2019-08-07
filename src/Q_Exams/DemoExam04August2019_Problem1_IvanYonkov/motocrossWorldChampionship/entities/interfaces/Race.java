package Q_Exams.DemoExam04August2019_Problem1_IvanYonkov.motocrossWorldChampionship.entities.interfaces;

import java.util.Collection;

public interface Race {
    String getName();

    int getLaps();

    Collection<Rider> getRiders();

    void addRider(Rider rider);
}
