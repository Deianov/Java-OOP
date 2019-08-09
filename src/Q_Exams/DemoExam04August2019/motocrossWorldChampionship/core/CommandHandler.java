package Q_Exams.DemoExam04August2019.motocrossWorldChampionship.core;

import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.core.interfaces.ChampionshipController;

public class CommandHandler {
    private ChampionshipController controller;

    public CommandHandler(ChampionshipController controller) {
        this.controller = controller;
    }

    public String handleCommand(String... arguments){
        String commandName = arguments[0];
        String name = arguments[1];
        String model;
        String output = null;

        switch (commandName){
            case "CreateRider":
                output = controller.createRider(name);
                break;
            case "CreateMotorcycle":
                model = arguments[2];
                int horsepower = Integer.parseInt(arguments[3]);
                output = controller.createMotorcycle(name, model, horsepower);
                break;
            case "AddMotorcycleToRider":
                model = arguments[2];
                output = controller.addMotorcycleToRider(name, model);
                break;
            case "AddRiderToRace":
                String riderName = arguments[2];
                output = controller.addRiderToRace(name, riderName);
                break;
            case "CreateRace":
                int laps = Integer.parseInt(arguments[2]);
                output = controller.createRace(name, laps);
                break;
            case "StartRace":
                output = controller.startRace(name);
                break;
        }
        return output;
    }
}
