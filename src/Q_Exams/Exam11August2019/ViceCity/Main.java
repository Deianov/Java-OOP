package Q_Exams.Exam11August2019.ViceCity;

import Q_Exams.Exam11August2019.ViceCity.core.ControllerImpl;
import Q_Exams.Exam11August2019.ViceCity.core.EngineImpl;
import Q_Exams.Exam11August2019.ViceCity.core.interfaces.Controller;
import Q_Exams.Exam11August2019.ViceCity.core.interfaces.Engine;


public class Main {
    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
