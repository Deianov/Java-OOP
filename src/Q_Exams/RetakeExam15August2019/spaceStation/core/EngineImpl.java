package Q_Exams.RetakeExam15August2019.spaceStation.core;

import Q_Exams.RetakeExam15August2019.spaceStation.common.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EngineImpl implements Engine {
    private Controller controller;
    private BufferedReader reader;

    public EngineImpl(Controller controller) {
        this.controller = controller;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        while (true) {
            String result = null;
            try {
                result = processInput();

                if (result.equals(Command.Exit.name())) {
                    break;
                }
            } catch (NullPointerException | IllegalArgumentException | IOException e) {
                result = e.getMessage();
            }

            System.out.println(result);
        }
    }

    private String processInput() throws IOException {
        String input = this.reader.readLine();
        String[] tokens = input.split("\\s+");

        Command command = Command.valueOf(tokens[0]);
        String result = null;
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        switch (command) {
            case AddAstronaut:
                result = addAstronaut(data);
                break;
            case AddPlanet:
                result = addPlanet(data);
                break;
            case RetireAstronaut:
                result = retireAstronaut(data);
                break;
            case ExplorePlanet:
                result = explorePlanet(data);
                break;
            case Report:
                result = report();
                break;
            case Exit:
                result = Command.Exit.name();
                break;
        }

        return result;
    }

    private String retireAstronaut(String[] data) {
        String name = data[0];
        String result = controller.retireAstronaut(name);
        return result;
    }

    private String report() {
        String result = controller.report();
        return result;
    }

    private String explorePlanet(String[] data) {
        String name = data[0];
        String result = controller.explorePlanet(name);
        return result;
    }

    private String addPlanet(String[] data) {
        String name = data[0];
        String[] items = Arrays.stream(data).skip(1).toArray(String[]::new);
        String result = controller.addPlanet(name, items);
        return result;
    }

    private String addAstronaut(String[] data) {
        String type = data[0];
        String name = data[1];
        String result = controller.addAstronaut(type, name);
        return result;
    }
}
