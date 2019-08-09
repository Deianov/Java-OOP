package Q_Exams.DemoExam04August2019.motocrossWorldChampionship.io;

import Q_Exams.DemoExam04August2019.motocrossWorldChampionship.io.interfaces.InputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReaderImpl implements InputReader {
    private final BufferedReader reader;

    public InputReaderImpl() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String readLine() throws IOException {
        return reader.readLine();
    }
}
