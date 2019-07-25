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
    public void log(String time, String message, ReportLevel reportLevel) {
        this.logAll(time, message, reportLevel);
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
