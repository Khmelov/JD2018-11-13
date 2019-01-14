package by.it.vchernetski.calcwithpatterns;

import java.util.Locale;

public abstract class ReportBuilder {
    Report report;
    public void creatNewReport(){this.report=new Report();}
    public abstract void writeStartTime(Locale locale);
    public abstract void writeErrors(Exception e);
    public abstract void writeBodyReprot(String text);
    public abstract void writeFinishTime(Locale locale);
    public abstract void writeToFile();
}
