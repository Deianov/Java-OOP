package Q_Exams.DemoExam04August2019_Problem1_IvanYonkov.motocrossWorldChampionship.repositories;

import Q_Exams.DemoExam04August2019_Problem1_IvanYonkov.motocrossWorldChampionship.entities.interfaces.Race;

public class RiceRepository extends RepositoryAbstract<Race> {
    @Override
    protected String getKey(Race model) {
        return model.getName();
    }
}
