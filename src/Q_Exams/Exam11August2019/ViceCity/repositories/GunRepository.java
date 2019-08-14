package Q_Exams.Exam11August2019.ViceCity.repositories;

import Q_Exams.Exam11August2019.ViceCity.models.guns.Gun;
import Q_Exams.Exam11August2019.ViceCity.repositories.interfaces.Repository;

import java.util.*;

public class GunRepository implements Repository<Gun> {
    private final Map<String, Gun> models;


    public GunRepository() {
        this.models = new LinkedHashMap<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return Collections.unmodifiableCollection(this.models.values());
    }

    @Override
    public void add(Gun model) {
        if (model == null) {
            return;
        }
        this.models.putIfAbsent(model.getName(), model);
    }

    @Override
    public boolean remove(Gun model) {
        if (model == null) {
            return false;
        }
        Gun removed = this.models.remove(model.getName());
        boolean isRemoved = true;

        if (removed == null) {
            isRemoved = false;
        }
        return isRemoved;
    }

    @Override
    public Gun find(String name) {
        return this.models.get(name);
    }
}
