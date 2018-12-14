package by.it._examples_.jd01_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Class05_Crawler {
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            URL site = new URL("http://www.dictionary.com/");
            reader = new BufferedReader(new InputStreamReader(site.openStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            //...
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                //...
            }
        }
    }
}
