package by.it.nickgrudnitsky.calc;

import java.util.Locale;

public class ReportWriter {
    private ReportBuilder reportBuilder;
    private Locale locale;

    ReportWriter(ReportBuilder reportBuilder, Locale locale) {
        this.reportBuilder = reportBuilder;
        this.locale = locale;
        reportBuilder.createNewReport(locale);
    }

    public void addOperation(String text) {
        reportBuilder.addOperation(text);
    }
    public void finisReport(){
        reportBuilder.endTime(locale);
        reportBuilder.save();
    }
}
