package by.it.karnilava.jd02_03;


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;

public class Buyer extends Thread implements Runnable, IBuyer, IUseBasket {
    int num;
    int n;
    // номер покупателя
    static int amountForCashier;
    boolean pensioner;
    ConcurrentHashMap<Integer, Integer> basketOfGoods = new ConcurrentHashMap<>();
    static final Object lockOnBuyer = new Object();
    private static Semaphore semaphore = new Semaphore(20);


    //консруктор покупателя с его номером
    Buyer(int num, boolean pensioner) {
        this.num = num;
        this.setName("Buyer # " + num + " ");
        this.pensioner = pensioner;

        start();
    }

    @Override // покупатель приходит в зал и выбирает продукты
    public void run() {

        //РЕАЛИЗАЦИЯ СЕМАФОРА для покупателей
//try {
//semaphore.acquire();
            enterToMarket();
            takeBasket();
            chooseGoods();
            putGoodsToBasket();
            goToQueue();
            goOut();
//    } catch (InterruptedException e) {
//    e.printStackTrace();
//}
//finally {
//    semaphore.release();
//}


    }

    public String toString() {
        return this.getName();
    }

    @Override
    public void enterToMarket() {


       // System.out.println(this + "has come to the shop");
            Runner.currentNumberOfBuyers.getAndAdd(+1);
         //   System.out.println("Buyers inside - "+Runner.currentNumberOfBuyers.get());



    }

    @Override
    public void chooseGoods() {
        try {
            int quantityOfGoods = Rnd.fromTo(1, 4);
            amountForCashier = quantityOfGoods; //чтобы определить, сколько времени кассир будет обслуживать покупателя
            for (int i = 0; i < quantityOfGoods; i++) {
                int pause = (int) (Rnd.fromTo(500, 2000) * (pensioner ? 1.5 : 1));
                Thread.sleep(pause);
                int productOfChoice = Rnd.fromTo(1, 4);
                int value = ListOfGoods.listOfGoods.get(productOfChoice);
              //  System.out.println(this + " want product#" + productOfChoice + ", value -" + value);
                basketOfGoods.put(productOfChoice, value);

            }
        } catch (InterruptedException e) {
            System.out.println(this + " //некорректное завершение ожидания");
        }
      //  System.out.println(this + "has chosen goods");
    }

    @Override
    public void goToQueue() {

       synchronized (lockOnBuyer) {
           while (QueueOfPensioneers.queueOfPensioneers.size() + QueueToCashier.queueToCashier.size() >= 30) {
               try {
                   Thread.sleep(1);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }

           }


           if (pensioner) {
               QueueOfPensioneers.queueOfPensioneers.add(this);
             //  System.out.println(this + " stands in the queue.HAVE A PRIORITY!");
               //System.out.println("Priority queue - " + QueueOfPensioneers.queueOfPensioneers);
           } else {
               QueueToCashier.queueToCashier.add(this);
             //  System.out.println(this + " stands in the queue");

           }
           int sizeOfQueue = QueueOfPensioneers.queueOfPensioneers.size() + QueueToCashier.queueToCashier.size();
         //  System.out.println("Queue size is " + sizeOfQueue);
       }



       // System.out.println("Common queue - " + QueueToCashier.queueToCashier);
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void goOut() {

        synchronized (lockOnBuyer) {
            try {
                AvailableBaskets.availableBaskets.put(n);
              //  System.out.println(this + "has come out the shop");
                Runner.currentNumberOfBuyers.getAndAdd(-1);
//                System.out.println("Buyers inside - " + Runner.currentNumberOfBuyers.get());
//                System.out.println("Baskets left - "+AvailableBaskets.availableBaskets.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

    @Override
    public void takeBasket() {
        synchronized (lockOnBuyer) {
            try {
                 n = AvailableBaskets.availableBaskets.take();
                int pause = (int) (Rnd.fromTo(100, 200) * (pensioner ? 1.5 : 1));
                Thread.sleep(pause);
               // System.out.println(this + "has taken a basket # " + n);
            } catch (InterruptedException e) {
                System.out.println(this + " //некорректное завершение ожидания");
            }


        }
    }


    @Override
    public void putGoodsToBasket() {
        try {


            int pause = (int) (Rnd.fromTo(100, 200) * (pensioner ? 1.5 : 1));
            Thread.sleep(pause);


        } catch (InterruptedException e) {
            System.out.println(this + " //некорректное завершение ожидания");
        }
       // System.out.println(this + "has put goods in the basket");
    }


}


