package F_SOLID.Exercises.Logger.interfaces;

import F_SOLID.Exercises.Logger.enums.ReportLevel;

import java.io.FileNotFoundException;

public interface Appender {
    void append(String time, String message, ReportLevel reportLevel);
    void setReportLevel(ReportLevel reportLevel);
}
