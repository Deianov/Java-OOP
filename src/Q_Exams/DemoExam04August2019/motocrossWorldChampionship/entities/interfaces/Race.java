package Q_Exams.DemoExam04August2019.motocrossWorldChampionship.entities.interfaces;

import java.util.Collection;

public interface Race {
    String getName();

    int getLaps();

    Collection<Rider> getRiders();

    void addRider(Rider rider);
}
