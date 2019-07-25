package F_SOLID.Exercises.Logger.interfaces;

public interface File {
    boolean write(String text);
    int getSize();
    void append(String text);
}
