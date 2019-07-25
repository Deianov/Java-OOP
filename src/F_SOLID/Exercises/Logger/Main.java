package F_SOLID.Exercises.Logger;

import F_SOLID.Exercises.Logger.controllers.EngineImpl;
import F_SOLID.Exercises.Logger.controllers.InputParser;
import F_SOLID.Exercises.Logger.factory.LoggerFactory;
import F_SOLID.Exercises.Logger.interfaces.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final Factory<Logger> LOGGER_FACTORY = new LoggerFactory();
    private static Engine engine;


    public static void main(String[] args) throws IOException {
        InputParser inputParser = new InputParser();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Logger logger = Main.LOGGER_FACTORY.produce(inputParser.readLoggerInfo(bufferedReader));

        Main.engine = new EngineImpl(logger);
        Main.engine.run("END", bufferedReader);

        System.out.println(engine.toString());

    }
}
