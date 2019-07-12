package F_SOLID.Exercises.Logger.models;

import F_SOLID.Exercises.Logger.enums.ReportLevel;
import F_SOLID.Exercises.Logger.interfaces.Appender;
import F_SOLID.Exercises.Logger.interfaces.Logger;

public class MessageLogger implements Logger {
    private Appender[] appenders;

    public MessageLogger(Appender... appenders) {
        this.appenders = appenders;
    }

    private void logAll(String time, String message, ReportLevel reportLevel) {
        for (Appender appender : appenders) {
            appender.append(time, message, reportLevel);
        }
    }

    @Override
    public void logInfo(String time, String message) {
        this.logAll(time, message, ReportLevel.INFO);
    }

    @Override
    public void logWarning(String time, String message) {
        this.logAll(time, message, ReportLevel.WARNING);
    }

    @Override
    public void logError(String time, String message) {
        this.logAll(time, message, ReportLevel.ERROR);
    }

    @Override
    public void logCritical(String time, String message) {
        this.logAll(time, message, ReportLevel.CRITICAL);
    }

    @Override
    public void logFatal(String time, String message) {
        this.logAll(time, message, ReportLevel.FATAL);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Logger info");
        stringBuilder.append(System.lineSeparator());
        for (Appender appender : this.appenders) {
            stringBuilder
                    .append(System.lineSeparator())
                    .append(appender.toString());
        }
        return stringBuilder.toString();
    }


}
