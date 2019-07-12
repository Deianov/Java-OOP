package F_SOLID.Exercises.Logger.interfaces;

public interface Factory<T> {
    T produce(String produceData);
}
