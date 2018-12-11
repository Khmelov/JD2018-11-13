package by.it.kruglenja.jd01_13;

import java.text.ParseException;
import java.util.HashMap;

/**
 * Created by user on 11.12.2018.
 */
public class TaskA {
    public static void main(String[] args) {
        if (Math.random() > 0.5) {
            try {
                new HashMap<String, String>(null);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
//            } else {
//                try {
//                    Integer.parseInt("привет");
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//
        }

    }
}
