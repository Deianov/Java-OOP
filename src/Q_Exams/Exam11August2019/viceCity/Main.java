package Q_Exams.Exam11August2019.viceCity;

import Q_Exams.Exam11August2019.viceCity.core.ControllerImpl;
import Q_Exams.Exam11August2019.viceCity.core.EngineImpl;
import Q_Exams.Exam11August2019.viceCity.core.interfaces.Controller;
import Q_Exams.Exam11August2019.viceCity.core.interfaces.Engine;


public class Main {
    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
