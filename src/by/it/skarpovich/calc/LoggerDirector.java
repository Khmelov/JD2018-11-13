package by.it.skarpovich.calc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

class LoggerDirector {

    private static LoggerDirector reporter;

    private LoggerDirector() {
    }

    static LoggerDirector getInstance() {
        if (reporter == null) {
            synchronized (LoggerDirector.class) {
                if (reporter == null) {
                    reporter = new LoggerDirector();
                }
            }
        }
        return reporter;
    }

    synchronized void log(String text) {
        ReportBuilder reportBuilder;
        StringBuilder strbuilder = new StringBuilder();
        try (
                BufferedWriter out = new BufferedWriter(
                        new FileWriter(Util.getPath("report.html"), true)
                )) {

            Date d = new Date();
            DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.LONG, ResMan.INSTANCE.getLocale());
            reportBuilder = new ShortReportBuilder();
            reportBuilder.createHeader("REPORT. start: " + dateFormat.format(d));
            String header = reportBuilder.getHeader();
            out.write(header);
            reportBuilder.createBody(text);
            strbuilder.append(reportBuilder.getBody()).append("end: ").append(dateFormat.format(d)).append("\n");
            out.write(strbuilder.toString());

            out.flush();

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
