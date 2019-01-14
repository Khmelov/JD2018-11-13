package by.it.skarpovich.calc;

public class ShortReportBuilder extends ReportBuilder {

    @Override
    public void createHeader(String headerText){

        text1.append(headerText);
        text1.append("\n");

    }

    @Override
    public void createBody(String bodyText){
        text2.append(bodyText);
        text2.append("\n");


    }
}
