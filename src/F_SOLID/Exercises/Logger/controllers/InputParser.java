package F_SOLID.Exercises.Logger.controllers;

import java.io.BufferedReader;
import java.io.IOException;

public class InputParser {


   public String readLoggerInfo(BufferedReader bufferedReader) throws IOException {
        int n = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();
        while (n-- > 0) {
            stringBuilder.append(bufferedReader.readLine()).append(System.lineSeparator());
        }

        return stringBuilder.toString();
   }
}
