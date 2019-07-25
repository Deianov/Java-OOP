package F_SOLID.Exercises.Logger.controllers;

import F_SOLID.Exercises.Logger.enums.ReportLevel;
import F_SOLID.Exercises.Logger.interfaces.Engine;
import F_SOLID.Exercises.Logger.interfaces.Logger;

import java.io.BufferedReader;
import java.io.IOException;


public class EngineImpl implements Engine {

    private Logger logger;

    public EngineImpl (Logger logger) {
        this.logger = logger;
    }

    @Override
    public void run(String endString, BufferedReader bufferedReader) throws IOException {

        String input = bufferedReader.readLine();

        // input parser

        while (!input.equals(endString)) {

            String[] tokens = input.split("\\|");

            ReportLevel reportLevel = ReportLevel.valueOf(tokens[0]);
            String time = tokens[1];
            String message = tokens[2];

            this.logger.log(time, message, reportLevel);

            input = bufferedReader.readLine();
        }

    }

    @Override
    public String toString() {
        return this.logger.toString();
    }
}
