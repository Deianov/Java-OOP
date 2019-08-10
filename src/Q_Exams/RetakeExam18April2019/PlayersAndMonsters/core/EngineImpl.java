package Q_Exams.RetakeExam18April2019.PlayersAndMonsters.core;

import Q_Exams.RetakeExam18April2019.PlayersAndMonsters.common.Command;
import Q_Exams.RetakeExam18April2019.PlayersAndMonsters.core.interfaces.Engine;
import Q_Exams.RetakeExam18April2019.PlayersAndMonsters.core.interfaces.ManagerController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EngineImpl implements Engine {
    private BufferedReader reader;
    private ManagerController controller;

    public EngineImpl() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.controller = new ManagerControllerImpl();
    }

    @Override
    public void run() {


        while (true){
            String result;
            try {
                result = processInput();

                if (Command.Exit.name().equals(result)){
                    break;
                }

            } catch (IOException | IllegalArgumentException e) {

                result = e.getMessage();
            }
            System.out.println(result);
        }

    }

    private String processInput() throws IOException {
        String input = reader.readLine();
        String[] data = input.split("\\s+");
        String[] arguments = Arrays.stream(data).skip(1).toArray(String[]::new);

        Command command = Command.valueOf(data[0]);
        String result = null;

        switch (command){
            case AddPlayer :
                result = addPlayer(arguments);
                break;
            case AddCard:
                result = addCard(arguments);
                break;
            case AddPlayerCard:
                result = addPlayerCard(arguments);
                break;
            case Fight:
                result = fight(arguments);
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

    private String addPlayer(String[] arguments) {
        String type = arguments[0];
        String name = arguments[1];
        String result = this.controller.addPlayer(type, name);
        return result;
    }

    private String addCard(String[] arguments) {
        String type = arguments[0];
        String name = arguments[1];
        String result = this.controller.addCard(type, name);
        return result;
    }

    private String addPlayerCard(String[] arguments) {
        String username = arguments[0];
        String cardName = arguments[1];
        String result = this.controller.addPlayerCard(username,  cardName);
        return result;
    }

    private String fight(String[] arguments) {
        String attackUser = arguments[0];
        String enemyUser = arguments[1];
        String result = this.controller.fight(attackUser,  enemyUser);
        return result;

    }

    private String report() {
        String result = this.controller.report();
        return result;
    }
}
