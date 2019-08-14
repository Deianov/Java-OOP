package Q_Exams.Exam11August2019.ViceCity.core;

import Q_Exams.Exam11August2019.ViceCity.common.Command;
import Q_Exams.Exam11August2019.ViceCity.core.interfaces.Controller;
import Q_Exams.Exam11August2019.ViceCity.core.interfaces.Engine;

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
            case AddPlayer:
                result = addPlayer(data);
                break;
            case AddGun:
                result = addGun(data);
                break;
            case AddGunToPlayer:
                result = addGunToPlayer(data);
                break;
            case Fight:
                result = fight();
                break;
            case Exit:
                result = Command.Exit.name();
                break;
        }

        return result;
    }

    private String addPlayer(String[] data) {
        String playerName = data[0];
        String result = this.controller.addPlayer(playerName);
        return result;
    }

    private String addGun(String[] data) {
        String type = data[0];
        String model = data[1];
        String result = controller.addGun(type, model);
        return result;
    }

    private String addGunToPlayer(String[] data) {
        String playerName = data[0];
        String result = controller.addGunToPlayer(playerName);
        return result;
    }

    private String fight() {
        String result = controller.fight();
        return result;
    }
}
