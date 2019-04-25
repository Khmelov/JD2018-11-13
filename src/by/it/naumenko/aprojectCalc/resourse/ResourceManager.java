package by.it.naumenko.aprojectCalc.resourse;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
   INSTANCE;

   private ResourceManager(){setLocale(Locale.getDefault());}

   public ResourceBundle resourceBundle;

   public void setLocale(Locale locale){
       resourceBundle = ResourceBundle.getBundle("by.it.naumenko.aprojectCalc.resourse.text",locale);
   }

   public String get(String key){
       return resourceBundle.getString(key);
   }
}
