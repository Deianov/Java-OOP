package F_SOLID.Exercises.Logger.models;

import F_SOLID.Exercises.Logger.enums.ReportLevel;
import F_SOLID.Exercises.Logger.interfaces.Layout;

public class ConsoleAppender extends AppenderImpl {

    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    public ConsoleAppender(Layout layout, ReportLevel reportLevel) {
        super(layout, reportLevel);
    }

    @Override
    public void append(String time, String message, ReportLevel reportLevel) {
        super.incrementMessagesCount();
        if (this.canAppend(reportLevel)){
            String output = this.getLayout().format(time, message, reportLevel);
            System.out.println(output);
        }
    }
}
