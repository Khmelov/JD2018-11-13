package by.it.naumenko.jd02_01;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Shop {
    public static void main(String[] args) {
        List<Byuer> byuerList = new ArrayList<>();
        Tovar.clearTovar();
        System.out.println(Tovar.tovar.entrySet());
        System.out.println("Магазин открылся");
        for (int time = 0; time <120 ; time++) {
            int byuerCount=Util.random(2);
            for (int i = 0; i < byuerCount; i++) {
                Byuer byuer = new Byuer(++Util.byuerCounter);
                byuerList.add(byuer);

                byuer.start();if (byuerList.size()%4==0)
                    Byuer.pensioneer = true;
                else
                    Byuer.pensioneer = false;
            }
            Util.sleep(1000);
        }
        for (Byuer element : byuerList) {
            try {
                element.join();
            } catch (InterruptedException e) {
            }
        }
        System.out.println("Магазин закрылся");
    }
}
