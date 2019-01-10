package by.it.vchernetski.calcwithpatterns;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class ReportShortBuilder extends ReportBuilder{
    @Override
    public void writeToFile() {
        try(BufferedWriter out = new BufferedWriter(new FileWriter(Util.getPath("ShortReport.txt")))){
            out.write(report.getStartTime().toString());
            out.write(report.getBodyReport().toString());
            out.write(report.getFinishTime().toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void writeStartTime(Locale locale) {
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.SHORT, locale);
        Date date = new Date();
        String time = dateFormat.format(date);
        report.setStartTime(time+"\n");
    }

    @Override
    public void writeErrors(Exception e) {
        report.setBodyReport(e.getMessage()+"\n");
    }

    @Override
    public void writeBodyReprot(String text) {
        report.setBodyReport(text+"\n");
    }

    @Override
    public void writeFinishTime(Locale locale) {
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.SHORT, locale);
        Date date = new Date();
        report.setFinishTime(dateFormat.format(date)+"\n");
    }
}
