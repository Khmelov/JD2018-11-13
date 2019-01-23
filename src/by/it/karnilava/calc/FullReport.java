package by.it.karnilava.calc;

import java.io.*;
import java.text.DateFormat;
import java.util.TimeZone;

public class FullReport extends AbstractReportBuilder {
    DataOutputStream dos1 = null;

    FullReport() {
        String src = System.getProperty("user.dir") + "/src/by/it/karnilava/";
        String filename1 = src + "calc/fullReport.txt";
        File f1 = new File(filename1);

        try {

            dos1 = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f1, true)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void createReport() {
        AbstractReportBuilder fullReport = new FullReport();
        fullReport.createHeader();
        fullReport.startTime();
        fullReport.operations();
        fullReport.cancelTime();
         fullReport.closeReport();


    }


    @Override
    public void createHeader() {


        try {
            dos1.writeUTF("FULL REPORT" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void startTime() {
        try {
            DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL, TimeZone.LONG, by.it.karnilava.calc.SwitchLanguages.rb.getLocale());
            String startTime = df.format(RuntimeReport.startTime) + "\n";

            dos1.writeUTF(startTime);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void operations() {

        for (int i = 0; i < ListofErrors.listofErrors.size(); i++) {

            try {
                dos1.writeUTF(ListofErrors.listofErrors.get(i));
                dos1.writeUTF(TimeofErrors.timeOfErrors.get(i));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

    @Override
    public void cancelTime() {
        try {

            DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, TimeZone.LONG, by.it.karnilava.calc.SwitchLanguages.rb.getLocale());
            String cancelTime = df.format(RuntimeReport.cancelTime) + "\n";
            dos1.writeUTF(cancelTime);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void closeReport(){
        try {
            dos1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
