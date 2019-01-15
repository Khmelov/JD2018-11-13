package by.it.vchernetski.calcwithpatterns;

import java.util.Locale;

public class ReportWriter {
    private Locale locale;
    private ReportBuilder reportBuilder;
    ReportWriter(Locale locale, ReportBuilder reportBuilder){
        this.locale=locale;
        this.reportBuilder = reportBuilder;
        reportBuilder.creatNewReport();
        reportBuilder.writeStartTime(locale);
    }
    public void addOperation(String text){
        reportBuilder.writeBodyReprot(text);
    }
    public void addError(Exception e){
        reportBuilder.writeErrors(e);
    }
    public void finishReport(){
        reportBuilder.writeFinishTime(locale);
        reportBuilder.writeToFile();
    }
}
