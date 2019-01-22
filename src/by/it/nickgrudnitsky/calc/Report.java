package by.it.nickgrudnitsky.calc;


public class Report {
    private String startTime;
    private String endTime;
    private String result;

    Report() {

    }


    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getResult() {
        return result;
    }
}
