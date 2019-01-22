package by.it.karnilava.calc;

public abstract class AbstractReportBuilder {
    public abstract void createHeader ();
    public abstract void startTime();
    public abstract void operations();
    public abstract void cancelTime();
    public abstract void closeReport();
}
