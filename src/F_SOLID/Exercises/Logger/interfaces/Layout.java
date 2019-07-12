package F_SOLID.Exercises.Logger.interfaces;

import F_SOLID.Exercises.Logger.enums.ReportLevel;

public interface Layout {
    String format(String time, String message, ReportLevel reportLevel);
}
