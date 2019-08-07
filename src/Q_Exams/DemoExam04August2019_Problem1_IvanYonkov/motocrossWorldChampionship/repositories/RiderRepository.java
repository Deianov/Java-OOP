package Q_Exams.DemoExam04August2019_Problem1_IvanYonkov.motocrossWorldChampionship.repositories;

import Q_Exams.DemoExam04August2019_Problem1_IvanYonkov.motocrossWorldChampionship.entities.interfaces.Rider;

public class RiderRepository extends RepositoryAbstract<Rider> {

    @Override
    protected String getKey(Rider model) {
        return model.getName();
    }
}
