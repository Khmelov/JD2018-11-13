package by.it.karnilava.jd02_03;

import java.util.HashMap;

class ListOfGoods {
   static HashMap<Integer, Integer> listOfGoods;
   public ListOfGoods() {
       listOfGoods = new HashMap();
       for (int i = 1; i < 5; i++) {


           listOfGoods.put(i, i*3+10);
           //System.out.println("Prise of good #"+i+"-"+listOfGoods.get(i));

       }


   }
}
