package Q_Exams.DemoExam04August2019.motocrossWorldChampionship.repositories;

import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.common.ExceptionMessages;
import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.entities.interfaces.Rider;
import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class RiderRepository implements Repository<Rider> {
    private Map<String, Rider> collection;

    public RiderRepository() {
        this.collection = new LinkedHashMap<>();
    }

    @Override
    public Rider getByName(String name){
        return this.collection.get(name);
    }

    @Override
    public Collection<Rider> getAll() {
        return this.collection.values();
    }

    @Override
    public void add(Rider model) {
        if (collection.containsKey(model.getName())){
            throw new IllegalArgumentException(String.format(ExceptionMessages.RIDER_EXISTS, model.getName()));
        }
        this.collection.put(model.getName(), model);
    }

    @Override
    public boolean remove(Rider model) {
        return this.collection.remove(model.getName()) != null;
    }
}
