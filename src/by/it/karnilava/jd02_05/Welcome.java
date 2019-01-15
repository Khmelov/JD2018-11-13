package by.it.karnilava.jd02_05;


import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Welcome {


    public static void main(String[] args) {

        String country = "EN" ;
        String language = "en" ;

        Locale locale = new Locale(language, country);
        Locale.setDefault(locale);
        ResourceBundle rb = ResourceBundle.getBundle("by.it.karnilava.jd02_05.MessageBundleGreeting",locale);
        String l = rb.getString("languageChoice");
        System.out.println(l);
        String s3 = rb.getString("end");
        System.out.println(s3);

        Scanner scanner = new Scanner(System.in);
        String line  = scanner.nextLine();

        while (!line.equals("end")){
            new SwitchLanguages(line);

            line=scanner.nextLine();

        }





    }


}




