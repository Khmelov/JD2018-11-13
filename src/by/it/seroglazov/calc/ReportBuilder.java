package by.it.seroglazov.calc;

import java.util.*;

class ReportBuilder {
    private String header;
    private Date beginWorkTime;
    private Date endWorkTime;
    private boolean shortStyle = true;
    private Locale locale = Locale.getDefault();
    private Queue<String> lines = new LinkedList<>();

    ReportBuilder(){
    }

    ReportBuilder setHeader(String header){
        this.header = header;
        return this;
    }

    ReportBuilder setBeginWorkTime(Date beginWorkTime) {
        this.beginWorkTime = beginWorkTime;
        return this;
    }

    ReportBuilder setEndWorkTime(Date endWorkTime) {
        this.endWorkTime = endWorkTime;
        return this;
    }

    ReportBuilder setShortStyle(boolean shortStyle) {
        this.shortStyle = shortStyle;
        return this;
    }

    ReportBuilder setLocale(Locale locale) {
        this.locale = locale;
        return this;
    }

    ReportBuilder addOperation(String operation, String result){
        lines.add("Operation: " + operation + "; Result: " + result);
        return this;
    }

    ReportBuilder addException(String type, String detail){
        if (shortStyle) lines.add("ERROR: " + type);
        else lines.add("ERROR: " + type + " - " +detail);
        return this;
    }

    Report build(){
        return new Report(header, beginWorkTime, endWorkTime, shortStyle, locale, lines);
    }



}
