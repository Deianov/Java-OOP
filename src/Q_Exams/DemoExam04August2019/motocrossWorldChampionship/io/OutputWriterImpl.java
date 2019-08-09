package Q_Exams.DemoExam04August2019.motocrossWorldChampionship.io;

import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.io.interfaces.OutputWriter;

public class OutputWriterImpl implements OutputWriter {
    @Override
    public void writeLine(String text) {
        System.out.println(text);
    }
}
