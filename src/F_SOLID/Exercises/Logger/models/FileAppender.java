package F_SOLID.Exercises.Logger.models;

import F_SOLID.Exercises.Logger.enums.ReportLevel;
import F_SOLID.Exercises.Logger.interfaces.File;
import F_SOLID.Exercises.Logger.interfaces.Layout;

public class FileAppender extends AppenderImpl {
    private File file;

    public FileAppender(Layout layout) {
        super(layout);
        this.file = new LogFile();

    }

    public FileAppender(Layout layout, ReportLevel reportLevel) {
        super(layout, reportLevel);
        this.file = new LogFile();
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public void append(String time, String message, ReportLevel reportLevel){
        super.incrementMessagesCount();
        if (this.file == null) {
            // TODO: 11.7.2019  
            throw new IllegalCallerException("File not set!");
        }
        if (this.canAppend(reportLevel)) {
            String text = this.getLayout().format(time, message, reportLevel);
            file.append(text);
            file.write(text);
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", File size: " + this.file.getSize();
    }
}
