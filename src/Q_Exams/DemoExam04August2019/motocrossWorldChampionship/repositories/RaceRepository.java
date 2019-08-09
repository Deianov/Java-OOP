package Q_Exams.DemoExam04August2019.motocrossWorldChampionship.repositories;

import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.common.ExceptionMessages;
import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.entities.interfaces.Race;
import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;


public class RaceRepository implements Repository<Race> {
    private Map<String, Race> collection;

    public RaceRepository() {
        this.collection = new LinkedHashMap<>();
    }

    @Override
    public Race getByName(String name){
        return this.collection.get(name);
    }

    @Override
    public Collection<Race> getAll() {
        return this.collection.values();
    }

    @Override
    public void add(Race model) {
        if (collection.containsKey(model.getName())){
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_EXISTS, model.getName()));
        }
        this.collection.put(model.getName(), model);
    }

    @Override
    public boolean remove(Race model) {
        return this.collection.remove(model.getName()) != null;
    }
}
