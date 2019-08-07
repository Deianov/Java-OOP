package Q_Exams.DemoExam04August2019_Problem1_IvanYonkov.motocrossWorldChampionship.repositories.interfaces;

import java.util.Collection;

public interface Repository<T> {
    T getByName(String name);

    Collection<T> getAll();

    void add(T model);

    boolean remove(T model);
}
