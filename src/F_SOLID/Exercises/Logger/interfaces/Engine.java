package F_SOLID.Exercises.Logger.interfaces;

import java.io.BufferedReader;
import java.io.IOException;

public interface Engine {
    void run(String endString, BufferedReader bufferedReader) throws IOException;
}
