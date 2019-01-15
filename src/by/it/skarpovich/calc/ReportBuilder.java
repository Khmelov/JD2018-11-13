package by.it.skarpovich.calc;

public abstract class ReportBuilder {
    StringBuilder text1 = new StringBuilder();
    StringBuilder text2 = new StringBuilder();
    public abstract void createHeader(String headerText);
    public abstract void createBody(String bodyText);
    public String getHeader() {return text1.toString();}
    public String getBody() {return text2.toString();}

}
