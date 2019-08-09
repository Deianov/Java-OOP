package Q_Exams.DemoExam04August2019.motocrossWorldChampionship.core;

import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.common.ExceptionMessages;
import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.common.OutputMessages;
import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.core.interfaces.ChampionshipController;
import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.entities.*;
import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.entities.interfaces.Motorcycle;
import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.entities.interfaces.Race;
import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.entities.interfaces.Rider;
import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.List;
import java.util.stream.Collectors;


public class ChampionshipControllerImpl implements ChampionshipController {
    private static final int MINIMUM_RACE_PARTICIPANTS = 3;

    private Repository<Rider> riderRepository;
    private Repository<Motorcycle> motorcycleRepository;
    private Repository<Race> raceRepository;

    public ChampionshipControllerImpl(Repository<Rider> riderRepository, Repository<Motorcycle> motorcycleRepository, Repository<Race> raceRepository) {
        this.riderRepository = riderRepository;
        this.motorcycleRepository = motorcycleRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createRider(String riderName) {
        riderRepository.add(new RiderImpl(riderName));
        return String.format(OutputMessages.RIDER_CREATED, riderName);
    }

    @Override
    public String createMotorcycle(String type, String model, int horsePower) {
        Motorcycle motorcycle = null;

        if (type.equals("Speed")) {
            motorcycle = new SpeedMotorcycle(model, horsePower);
        }else if (type.equals("Power")) {
            motorcycle = new PowerMotorcycle(model, horsePower);
        }
        motorcycleRepository.add(motorcycle);
        return String.format(OutputMessages.MOTORCYCLE_CREATED,type + "Motorcycle", model);
    }

    @Override
    public String addMotorcycleToRider(String riderName, String motorcycleModel) {
        Rider rider = riderRepository.getByName(riderName);
        Motorcycle motorcycle = motorcycleRepository.getByName(motorcycleModel);
        rider.addMotorcycle(motorcycle);
        return String.format(OutputMessages.MOTORCYCLE_ADDED, riderName, motorcycleModel);
    }

    @Override
    public String addRiderToRace(String raceName, String riderName) {
        Race race = raceRepository.getByName(raceName);
        Rider rider = riderRepository.getByName(riderName);
        if (race == null){
            throw new NullPointerException(String.format(ExceptionMessages.RACE_NOT_FOUND, raceName));
        }
        if (rider == null){
            throw new NullPointerException(String.format(ExceptionMessages.RIDER_NOT_FOUND, riderName));
        }
        race.addRider(rider);
        return String.format(OutputMessages.RIDER_ADDED, riderName, raceName);
    }

    @Override
    public String startRace(String raceName) {

        Race race = raceRepository.getByName(raceName);
        if (race == null) {
            throw new NullPointerException(String.format(ExceptionMessages.RACE_NOT_FOUND, raceName));
        }

        List<Rider> riders = race.getRiders()
                .stream()
                .filter(Rider::getCanParticipate)
                .collect(Collectors.toList());

        if (riders.size() < 3){
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_INVALID, raceName, MINIMUM_RACE_PARTICIPANTS));
        }

        int laps = race.getLaps();

        riders = riders
                .stream()
                .sorted((r1, r2) -> {
                   double rider1 = r1.getMotorcycle().calculateRacePoints(laps);
                   double rider2 = r2.getMotorcycle().calculateRacePoints(laps);
                   return Double.compare(rider2, rider1);
                })
                .limit(3)
                .collect(Collectors.toList());

        riders.get(0).winRace();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(String.format(OutputMessages.RIDER_FIRST_POSITION, riders.get(0).getName(), race.getName()))
                .append(System.lineSeparator())
                .append(String.format(OutputMessages.RIDER_SECOND_POSITION, riders.get(1).getName(), race.getName()))
                .append(System.lineSeparator())
                .append(String.format(OutputMessages.RIDER_THIRD_POSITION, riders.get(2).getName(), race.getName()));

        return stringBuilder.toString();
    }

    @Override
    public String createRace(String name, int laps) {
        raceRepository.add(new RaceImpl(name, laps));
        return String.format(OutputMessages.RACE_CREATED, name);
    }
}
