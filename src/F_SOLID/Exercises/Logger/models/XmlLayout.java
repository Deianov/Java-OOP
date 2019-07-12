package F_SOLID.Exercises.Logger.models;

import F_SOLID.Exercises.Logger.enums.ReportLevel;
import F_SOLID.Exercises.Logger.interfaces.Layout;

public class XmlLayout implements Layout {

    @Override
    public String format(String time, String message, ReportLevel reportLevel) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("<log>")
                .append('\n').append('\t')
                .append("<date>").append(time).append("</date>")
                .append('\n').append('\t')
                .append("<level>").append(reportLevel.toString()).append("</level>")
                .append('\n').append('\t')
                .append("<message>").append(message).append("</message>")
                .append('\n')
                .append("</log>");

        return stringBuilder.toString();
    }
}
