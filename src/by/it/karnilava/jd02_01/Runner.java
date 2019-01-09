package by.it.karnilava.jd02_01;

import java.util.ArrayDeque;
import java.util.Queue;

public class Runner {
    static int countBuyers = 0; // общий счетчик покупателей
    static Queue<Buyer> queue = new ArrayDeque<>();


    public static void main(String[] args) throws InterruptedException {
        new ListOfGoods();

        // Блок кода для времени, когда число людей в магазине сначал должно быть порядка 10, а потом увеличиться до 30-40


        for (int time = 0; time < 120; time++) {
            if (time < 31) {
                add10Buyers(time);
            }
            if (time > 60 && time < 91) {
                add10Buyers(time-60);

            }

           // Блок для времени, когда число людей в магазине варьируется от 30 до 40
            else {

                int seconds;
                if (time > 30 && time<60) {
                    seconds = time;
                    add30_40Buyers(seconds);
                }
                if (time>90&&time<120){
                    seconds = time -60 ;
                    add30_40Buyers(seconds);
                }



            }
            System.out.println(time + " " + countBuyers);
            Thread.sleep(1000);
        }


    }

    static void add30_40Buyers(int seconds) {
        if (countBuyers <= (40 +(30 - seconds))) {

            int count = Rnd.fromTo(0, 2);
            for (int i = 0; i <= count; i++) {
                countBuyers++;
                if (countBuyers < (40 +(30 - seconds))) {
                    if (countBuyers % 4 == 0) {
                        Buyer buyer = new Buyer(countBuyers, true);
                        queue.add(buyer);
                        System.out.println("Attention! " + buyer + " is a pensioneer!");
                    } else {

                        Buyer buyer = new Buyer(countBuyers, false);
                        queue.add(buyer);
                    }

                }
            }
        }
    }

    static void add10Buyers(int time)  {

        while (countBuyers < 10+time) {
            int count = Rnd.fromTo(0, 2);
            for (int i = 0; i <= count; i++) {
                countBuyers++;

                    if (countBuyers % 4 == 0) {
                        Buyer buyer = new Buyer(countBuyers, true);
                        queue.add(buyer);
                        System.out.println("Attention! " + buyer + " is a pensioneer!");
                    } else {
                        Buyer buyer = new Buyer(countBuyers, false);
                        queue.add(buyer);


                }
            }
        }
    }
}


