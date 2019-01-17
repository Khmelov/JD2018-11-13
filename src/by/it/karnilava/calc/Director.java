package by.it.karnilava.calc;

public class Director {
    Director(){

    }

    static void buildReport(String line){
        switch (line){
            case "short": {
                new ShortReport();
                ShortReport.createReport();
                break;
            }
            case  "full": {
                FullReport.createReport();
                break;
            }
            default:
                System.out.println(SwitchLanguages.rb.getString("ERROR"));

        }
    }
}
