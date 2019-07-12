package F_SOLID.Exercises.Logger.models;

import F_SOLID.Exercises.Logger.interfaces.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.stream.Stream;

public class LogFile implements File {
    private static final String DEFAULT_PATH_AND_NAME = "log.txt";
    private StringBuilder text;
    private int size;
    private String filePathAndName;

    public LogFile() {
        this.text = new StringBuilder();
        this.size = 0;
        this.filePathAndName = LogFile.DEFAULT_PATH_AND_NAME;
    }

    public LogFile(String filePathAndName) {
        this();
        this.filePathAndName = filePathAndName;
    }

    public void setFilePathAndName(String filePathAndName) {
        this.filePathAndName = filePathAndName;
    }

    @Override
    public boolean write() {
        try {
            Files.write(Paths.get(this.filePathAndName),
                    this.text.toString().getBytes(), StandardOpenOption.APPEND);
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public int getSize() {
        return this.calculateSize();
    }

    private int calculateSize() {
       return this.text.toString()
                .chars()
                .filter(Character::isAlphabetic)
                .sum();

//        return Stream.of(this.text.toString().toCharArray())
//                .map(String::valueOf)
//                .filter(s -> Character.isAlphabetic(s.charAt(0)))
//                .mapToInt(e -> e.charAt(0))
//                .sum();
    }

    @Override
    public void append(String text) {
        this.text.append(text);
    }
}
