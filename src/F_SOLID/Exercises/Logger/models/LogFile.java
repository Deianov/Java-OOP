package F_SOLID.Exercises.Logger.models;

import F_SOLID.Exercises.Logger.interfaces.File;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static java.nio.charset.StandardCharsets.UTF_8;

public class LogFile implements File {
    private static final String DEFAULT_PATH_AND_NAME = "src/F_SOLID/Exercises/Logger/log.txt";
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
    public boolean write(String txt) {
        try {
            Files.write(Paths.get(this.filePathAndName), txt.getBytes(UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");

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
    }

    @Override
    public void append(String text) {
        this.text.append(text);
    }
}
