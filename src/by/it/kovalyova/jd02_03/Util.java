package by.it.kovalyova.jd02_03;

import java.util.*;

public class Util {

    static public HashMap<String, Double> assortiment = new HashMap<>(4);
    static void initassort() {
        assortiment.put("осетрина", 2.0);
        assortiment.put("балык", 3.0);
        assortiment.put("черная икра", 4.0);
        assortiment.put("шампанское", 5.0);
    }

    static int random(int max){
        return random(0, max);
    }
    static int random(int min, int max){
        return min + (int) (Math.random() * (max-min+1));
    }

    static List<String> goods(int rndCount) {
        //StringBuilder sb = new StringBuilder(50);


        Set<String> keySet = assortiment.keySet();
        List<String> listOfKeys = new ArrayList<>(keySet);
        //System.out.println(listOfKeys);
        Collections.shuffle(listOfKeys);
        return listOfKeys.subList(0, rndCount);
    }

    static  void sleep(int millis){
        try {
            Thread.sleep(millis/ Dispatcher.K_SPEED);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

