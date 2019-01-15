package by.it.vchernetski.calcwithpatterns;



public class Report {
    private StringBuilder startTime = new StringBuilder();
    private StringBuilder bodyReport = new StringBuilder();
    private StringBuilder finishTime = new StringBuilder();
    void setStartTime(String text){ startTime.append(text);}
    void setBodyReport(String text){
        bodyReport.append(text);
    }
    void setFinishTime(String text){
        finishTime.append(text);
    }

    public StringBuilder getStartTime() {
        return startTime;
    }

    public StringBuilder getBodyReport() {
        return bodyReport;
    }

    public StringBuilder getFinishTime() {
        return finishTime;
    }
}
