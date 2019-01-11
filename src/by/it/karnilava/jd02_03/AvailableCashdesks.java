package by.it.karnilava.jd02_03;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

class AvailableCashdesks {

 static Deque<Integer> availableCashdesks = new ConcurrentLinkedDeque<>();


   AvailableCashdesks () {

       for (int i = 2; i <= 5; i++) {


       availableCashdesks.add(i);

   }
   }
}
