package Q_Exams.DemoExam04August2019_Problem1_IvanYonkov.motocrossWorldChampionship.repositories;

import Q_Exams.DemoExam04August2019_Problem1_IvanYonkov.motocrossWorldChampionship.entities.interfaces.Motorcycle;

public class MotorcycleRepository extends RepositoryAbstract<Motorcycle> {

    @Override
    protected String getKey(Motorcycle model) {
        return model.getModel();
    }
}
