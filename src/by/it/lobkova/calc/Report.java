package by.it.lobkova.calc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Queue;

class Report {
    static ReportBuilder reportBuilder = new ReportBuilder();
    private String header;
    private Date beginWorkTime;
    private Date endWorkTime;
    private boolean shortStyle;
    private Locale locale;
    private Queue<String> lines;


    Report(String header, Date beginWorkTime, Date endWorkTime, boolean shortStyle, Locale locale, Queue<String> lines) {
        this.header = header;
        this.beginWorkTime = beginWorkTime;
        this.endWorkTime = endWorkTime;
        this.shortStyle = shortStyle;
        this.locale = locale;
        this.lines = lines;
    }

    void saveAsTextFile(File file) {
        int dtStyle;
        if (shortStyle) {
            dtStyle = DateFormat.SHORT;
        } else {
            dtStyle = DateFormat.MEDIUM;
        }
        DateFormat df = DateFormat.getDateTimeInstance(dtStyle, dtStyle, locale);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(header);
            bw.newLine();
            bw.newLine();
            bw.write("start time: ");
            bw.write(df.format(beginWorkTime));
            bw.newLine();
            bw.write("end time: ");
            bw.write(df.format(endWorkTime));
            bw.newLine();
            bw.newLine();
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}