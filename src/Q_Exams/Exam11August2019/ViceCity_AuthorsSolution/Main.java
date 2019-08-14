package Q_Exams.Exam11August2019.ViceCity_AuthorsSolution;

import Q_Exams.Exam11August2019.ViceCity_AuthorsSolution.core.ControllerImpl;
import Q_Exams.Exam11August2019.ViceCity_AuthorsSolution.core.interfaces.Controller;
import Q_Exams.Exam11August2019.ViceCity_AuthorsSolution.core.interfaces.Engine;
import Q_Exams.Exam11August2019.ViceCity_AuthorsSolution.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
