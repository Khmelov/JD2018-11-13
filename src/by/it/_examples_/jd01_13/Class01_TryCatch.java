package by.it._examples_.jd01_13;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;


public class Class01_TryCatch {

    //метод со встроенным обработчиком исключения
    public Double parseFromFrance(String numberStr) {
        NumberFormat nfFr = NumberFormat.getInstance(Locale.FRANCE);
        try {
            double numFr = nfFr.parse(numberStr).doubleValue();
            return numFr;

        } catch (ParseException e) { // проверяемое исключение
            // тут можно сделать:
            // 1) вызов стандартного исключения, например: IllegalArgumentException()
            // 2) создание собственного исключения
            // 3) return какого-то значения по умолчанию
            System.out.println("--Возникла ошибка парсера чисел для строки: " + numberStr);
            return null;
        }
    }

    //метод "выбрасывающий" исключение наверх
    public double parseFromFranceWithThrows(String numberStr) throws ParseException {
        NumberFormat nfFr = NumberFormat.getInstance(Locale.FRANCE);
        double numFr = nfFr.parse(numberStr).doubleValue();
        return numFr;
    }

    //метод не выбрасывающий исключение наверх с блоком finally
    public double parseFromFranceSilent(String numberStr) throws ParseException {
        NumberFormat nfFr = NumberFormat.getInstance(Locale.FRANCE);
        double numFr=-1;
        try {
            numFr = nfFr.parse(numberStr).doubleValue();
        }
        finally {
           return numFr; //выход из finally подавляет исключение
        }
        // return numFr; //а если бы вышли так, то исключение бы пробросилось.
    }

    public static void main(String[ ] args) {
        Class01_TryCatch cl=new Class01_TryCatch();
        Double db= null;
        try {
            db = cl.parseFromFranceSilent("vf0,12dfsf");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Второе число: "+db);

        Double d=cl.parseFromFrance("0,12");
        System.out.println("Первое число: "+d);

    }


}
