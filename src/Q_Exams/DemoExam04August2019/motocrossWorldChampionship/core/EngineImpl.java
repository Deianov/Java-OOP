package Q_Exams.DemoExam04August2019.motocrossWorldChampionship.core;

import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.core.interfaces.Engine;
import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.io.interfaces.InputReader;
import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.io.interfaces.OutputWriter;

import java.io.IOException;


public class EngineImpl implements Engine {
    private static final String END_COMMAND = "End";
    private final InputReader inputReader;
    private final OutputWriter outputWriter;
    private final CommandHandler commandHandler;

    public EngineImpl(InputReader inputReader, OutputWriter outputWriter, CommandHandler commandHandler) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.commandHandler = commandHandler;
    }

    @Override
    public void run() {

        String input = "";
        String output;

        while (true){

            try {
                input = inputReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (input.equals(END_COMMAND)){
                return;
            }

            try {
                output = commandHandler.handleCommand(input.split("\\s+"));
                this.outputWriter.writeLine(output);

            } catch (Exception ex){
                this.outputWriter.writeLine(ex.getMessage());
            }
        }
    }
}
