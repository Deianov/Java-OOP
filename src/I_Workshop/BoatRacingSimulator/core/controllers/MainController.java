package I_Workshop.BoatRacingSimulator.core.controllers;

import I_Workshop.BoatRacingSimulator.core.commandInterpreter.CommandInterpreter;
import I_Workshop.BoatRacingSimulator.io.interfaces.InputReader;
import I_Workshop.BoatRacingSimulator.io.interfaces.OutputWriter;
import I_Workshop.BoatRacingSimulator.models.Race;

public class MainController {
    private InputReader reader;
    private OutputWriter writer;
    private CommandInterpreter commandInterpreter;
    private Race race;
    private boolean isRunning;

    public MainController(InputReader reader, OutputWriter writer, CommandInterpreter commandInterpreter) {
        this.reader = reader;
        this.writer = writer;
        this.commandInterpreter = commandInterpreter;
        this.isRunning = false;
        this.race = null;
    }

    public void run() {
        this.isRunning = true;
        StringBuilder aggregator = new StringBuilder();
        while (this.isRunning) {

            String[] args = this.reader.readLine().split("\\\\");
            String type = args[0];
            String output = this.commandInterpreter.interpret(type, args);
            if (output.equals("End")) {
                this.writer.writeLine(aggregator.toString().trim());
                this.isRunning = false;
            } else {
                aggregator.append(output)
                        .append(System.lineSeparator());
            }
        }
    }
}
