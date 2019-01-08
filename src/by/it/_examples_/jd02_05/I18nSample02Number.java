package by.it._examples_.jd02_05;

import java.text.*;
import java.util.Locale;

public class I18nSample02Number {
    public static void main(String[] args) {
        NumberFormat nfGe = NumberFormat.getInstance(Locale.GERMAN);
        NumberFormat nfUs = NumberFormat.getInstance(Locale.US);
        NumberFormat nfFr = NumberFormat.getInstance(Locale.FRANCE);
        double iGe = 0, iUs = 0, iFr = 0;
        String str = "1.234,5"; // строка, представляющая число
        try {
            // преобразование строки в германский стандарт
            iGe = nfGe.parse(str).doubleValue();
            // преобразование строки в американский стандарт
            iUs = nfUs.parse(str).doubleValue();
        } catch (ParseException e) {
            System.err.print("Error position: " + e.getErrorOffset());
        }
        System.out.printf("iGe = %f\niUs = %f\n", iGe, iUs);
        // преобразование числа из германского в американский стандарт
        String sUs = nfUs.format(iGe);
        // преобразование числа из германского во французский стандарт
        String sFr = nfFr.format(iGe);
        System.out.println("\nUs " + sUs + "\nFr " + sFr);


    }
}
