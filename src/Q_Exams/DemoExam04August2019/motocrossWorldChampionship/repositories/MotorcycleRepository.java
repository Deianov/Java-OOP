package Q_Exams.DemoExam04August2019.motocrossWorldChampionship.repositories;

import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.common.ExceptionMessages;
import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.entities.interfaces.Motorcycle;
import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;


public class MotorcycleRepository implements Repository<Motorcycle> {
    private Map<String, Motorcycle> collection;

    public MotorcycleRepository() {
        this.collection = new LinkedHashMap<>();
    }

    @Override
    public Motorcycle getByName(String name){
        return this.collection.get(name);
    }

    @Override
    public Collection<Motorcycle> getAll() {
        return this.collection.values();
    }

    @Override
    public void add(Motorcycle model) {
        if (collection.containsKey(model.getModel())){
            throw new IllegalArgumentException(String.format(ExceptionMessages.MOTORCYCLE_EXISTS, model.getModel()));
        }
        this.collection.put(model.getModel(), model);
    }

    @Override
    public boolean remove(Motorcycle model) {
        return this.collection.remove(model.getModel()) != null;
    }
}
