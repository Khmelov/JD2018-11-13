package by.it.nickgrudnitsky.calc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class ShortReportBuilder extends ReportBuilder{

    @Override
    public void save() {
        try(BufferedWriter out = new BufferedWriter(new FileWriter(Util.getPath("ShortReport.txt")))){
            out.write(report.getStartTime());
            out.write(report.getResult());
            out.write(report.getEndTime());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void addOperation(String text) {
        report.setResult(text + "\n");
    }

    @Override
    public void startTime(Locale locale) {
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.SHORT, locale);
        Date date = new Date();
        report.setStartTime(dateFormat.format(date) +"\n");
    }

    @Override
    public void endTime(Locale locale) {
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.SHORT, locale);
        Date date = new Date();
        report.setEndTime(dateFormat.format(date) +"\n");
    }
}
