package by.it._examples_.jd01_13;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class Class05_Throw_e {

    public double parseFromFileBefore(String filename)
            throws FileNotFoundException, ParseException, IOException {
            NumberFormat nfFr = NumberFormat.getInstance(Locale.FRANCE);
        double numFr = 0;
        BufferedReader buff = null;
        try {
            FileReader fr = new FileReader(filename);
            buff = new BufferedReader(fr);
            String number = buff.readLine();
            numFr = nfFr.parse(number).doubleValue();
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        } catch (ParseException e) {
            throw e;
        } finally {
            if(buff != null) {
            buff.close();
            }
        }
        return numFr;
    }

    public double parseFromFile(String filename)
            throws FileNotFoundException, ParseException, IOException {
        NumberFormat nfFr = NumberFormat.getInstance(Locale.FRANCE);
        double numFr = 0;
        BufferedReader buff = null;
        try {
            FileReader fr = new FileReader(filename);
            buff = new BufferedReader(fr);
            String number = buff.readLine();
            numFr = nfFr.parse(number).doubleValue();
        } catch (final Exception e) { // final — необязателен
            throw e; // more precise rethrow
        } finally {
            if(buff != null) {
                buff.close();
            }
        }
        return numFr;
    }

    //----------------- вложенные блоки обработки ошибок -----------------------
    public class NestedTryCatchRunner {
        public void doAction() {
            try { // внешний блок
                int a = (int) (Math.random() * 2) - 1;
                System.out.println("a = " + a);
                try { // внутренний блок
                    int b = 1/a;
                    StringBuilder sb = new StringBuilder(a);
                } catch (NegativeArraySizeException e) {
                    System.err.println("недопустимый размер буфера: " + e);
                }
            } catch (ArithmeticException e) {
                System.err.println("деление на 0: " + e);
            }
        }
    }
}
