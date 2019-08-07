package Q_Exams.DemoExam04August2019_Problem1_IvanYonkov.motocrossWorldChampionship.repositories;

import Q_Exams.DemoExam04August2019_Problem1_IvanYonkov.motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class RepositoryAbstract<T> implements Repository<T> {

    protected Map<String, T> data;

    public RepositoryAbstract() {
        this.data = new LinkedHashMap<>();
    }

    protected abstract String getKey(T model);

    @Override
    public T getByName(String name) {
        return this.data.get(name);
    }

    @Override
    public Collection<T> getAll() {

        return this.data.values();
    }

    @Override
    public void add(T model) {

        this.data.put(this.getKey(model), model);
    }

    @Override
    public boolean remove(T model) {
        return this.data.remove(this.getKey(model)) != null;
    }
}
