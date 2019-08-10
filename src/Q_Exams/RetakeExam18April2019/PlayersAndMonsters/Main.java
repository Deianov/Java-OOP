package Q_Exams.RetakeExam18April2019.PlayersAndMonsters;

import Q_Exams.RetakeExam18April2019.PlayersAndMonsters.core.ManagerControllerImpl;
import Q_Exams.RetakeExam18April2019.PlayersAndMonsters.core.interfaces.ManagerController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ManagerController managerController = new ManagerControllerImpl();

        String line;

        while (!"Exit".equals(line = scanner.nextLine())){

            String[] data = line.split("\\s+");
            String command = data[0];
            String argumentOne = data.length > 1 ? data[1] : null;
            String argumentTwo = data.length > 1 ? data[2] : null;
            String output = "";

            try {
                switch (command){
                    case "AddPlayer" :
                        output = managerController.addPlayer(argumentOne, argumentTwo);
                        break;
                    case "AddCard" :
                        output = managerController.addCard(argumentOne, argumentTwo);
                        break;
                    case "AddPlayerCard" :
                        output = managerController.addPlayerCard(argumentOne, argumentTwo);
                        break;
                    case "Fight" :
                        output = managerController.fight(argumentOne, argumentTwo);
                        break;
                    case "Report" :
                        output = managerController.report();
                    break;
                }
                System.out.println(output);

            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
