package by.it.medvedeva.jd02_02;

import java.util.*;

public class Util {

    static int random(int max){
        return random(0, max);
    }
    static int random(int min, int max){
        return min + (int) (Math.random() * (max-min+1));
    }

    static String goods(int rndCount) {
        StringBuilder sb=new StringBuilder(50);

        HashMap<String, Double> hashMap = new HashMap<>(4);

        hashMap.put("осетрина", 2.0);
        hashMap.put("балык", 3.0);
        hashMap.put("черная икра", 4.0);
        hashMap.put("шампанское", 5.0);
        Set<String> keySet = hashMap.keySet();
        List<String> listOfKeys = new ArrayList<>(keySet);
        //System.out.println(listOfKeys);
        Collections.shuffle(listOfKeys);
        List<String> goodsList = listOfKeys.subList(0, rndCount);

        for (int i = 0; i < rndCount; i++) {
            sb.append(goodsList.get(i)).append(" - ").append(hashMap.get(goodsList.get(i))).append("р. ");
        }
        return sb.toString();}

    static  void sleep(int millis){
        try {
            Thread.sleep(millis/ Dispatcher.K_SPEED);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

