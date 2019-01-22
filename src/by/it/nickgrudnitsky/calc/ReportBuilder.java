package by.it.nickgrudnitsky.calc;

import java.util.Locale;

abstract class ReportBuilder {
    Report report;

    void createNewReport(Locale locale) {
        report = new Report();
        startTime(locale);
    }

    public abstract void addOperation(String text);

    public abstract void startTime(Locale locale);

    public abstract void endTime(Locale locale);

    public abstract void save();
}
