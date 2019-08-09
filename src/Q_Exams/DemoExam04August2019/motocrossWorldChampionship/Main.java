package Q_Exams.DemoExam04August2019.motocrossWorldChampionship;

import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.core.ChampionshipControllerImpl;
import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.core.CommandHandler;
import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.core.EngineImpl;
import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.core.interfaces.ChampionshipController;
import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.core.interfaces.Engine;
import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.entities.interfaces.Motorcycle;
import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.entities.interfaces.Race;
import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.entities.interfaces.Rider;
import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.io.InputReaderImpl;
import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.io.OutputWriterImpl;
import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.io.interfaces.InputReader;
import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.io.interfaces.OutputWriter;
import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.repositories.MotorcycleRepository;
import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.repositories.RaceRepository;
import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.repositories.RiderRepository;
import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.repositories.interfaces.Repository;

public class Main {
    public static void main(String[] args) {
        InputReader inputReader = new InputReaderImpl();
        OutputWriter outputWriter = new OutputWriterImpl();

        Repository<Rider> riderRepository = new RiderRepository();
        Repository<Motorcycle> motorcycleRepository = new MotorcycleRepository();
        Repository<Race> raceRepository = new RaceRepository();

        ChampionshipController controller = new ChampionshipControllerImpl(riderRepository, motorcycleRepository, raceRepository);
        CommandHandler commandHandler = new CommandHandler(controller);

        Engine engine = new EngineImpl(inputReader, outputWriter, commandHandler);
        engine.run();
    }
}
