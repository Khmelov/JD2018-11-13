package by.it.seroglazov.jd01_13;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskC {
    private static Scanner sc;
    public static void main(String[] args) throws NumberFormatException {
        sc = new Scanner(System.in);
        readData();
    }

    static void readData() throws NumberFormatException  {
        ArrayList<Double> dList = new ArrayList<>();
        int counter = 0;
        while (true) {
            try {
                String str = sc.nextLine();
                double d = Double.parseDouble(str);
                dList.add(d);
            } catch (NumberFormatException e) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException interEx){
                    interEx.printStackTrace();
                }
                StringBuilder sb = new StringBuilder();
                dList.sort((x,y) -> -x.compareTo(y) );
                dList.forEach(x -> sb.append(x).append(' '));
                System.out.println(sb);
                if (++counter > 4)
                    throw e;
            }
        }
    }
}
