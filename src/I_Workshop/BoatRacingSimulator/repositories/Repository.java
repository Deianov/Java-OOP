package I_Workshop.BoatRacingSimulator.repositories;

import I_Workshop.BoatRacingSimulator.exceptions.DuplicateModelException;
import I_Workshop.BoatRacingSimulator.exceptions.NonExistantModelException;
import I_Workshop.BoatRacingSimulator.models.interfaces.ModelGetter;

public interface Repository<T extends ModelGetter> {
    void add(T entity) throws DuplicateModelException;
    T get(String model) throws NonExistantModelException;
}
