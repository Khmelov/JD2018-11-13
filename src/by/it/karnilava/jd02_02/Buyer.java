package by.it.karnilava.jd02_02;


import java.util.concurrent.ConcurrentHashMap;

public class Buyer extends Thread implements Runnable, IBuyer, IUseBasket {
    int num;
    // номер покупателя
   static int amountForCashier;
 boolean pensioner;
  ConcurrentHashMap<Integer, Integer> basketOfGoods = new ConcurrentHashMap<>();



    //консруктор покупателя с его номером
     Buyer(int num, boolean pensioner) {
        this.num = num;
        this.setName("Buyer # "+num+" ");
        this.pensioner = pensioner;

        start();
    }

    @Override // покупатель приходит в зал и выбирает продукты
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goToQueue();
        goOut();
    }

    public String toString() {
        return this.getName();
    }

    @Override
    public void enterToMarket() {
      //  System.out.println(this + "has come to the shop");
        Runner.currentNumberOfBuyers.getAndAdd(+1);

    }

    @Override
    public void chooseGoods() {
        try {
            int quantityOfGoods = Rnd.fromTo(1,4);
            amountForCashier = quantityOfGoods; //чтобы определить, сколько времени кассир будет обслуживать покупателя
            for (int i = 0; i <quantityOfGoods ; i++) {
                int pause = (int)(Rnd.fromTo(500, 2000)*(pensioner ? 1.5 : 1));
                Thread.sleep( pause);
                int productOfChoice = Rnd.fromTo(1,4);
               int value = ListOfGoods.listOfGoods.get(productOfChoice);
              //  System.out.println(this+" want product#"+productOfChoice+", value -"+value);
                basketOfGoods.put(productOfChoice,value);

            }
        }
        catch (InterruptedException e){
            System.out.println(this+ " //некорректное завершение ожидания");
        }
      //  System.out.println(this +"has chosen goods");
    }

    @Override
    public void goToQueue() {
        if (pensioner) {
            QueueOfPensioneers.queueOfPensioneers.add(this);
            //  System.out.println(this+" stands in the queue.HAVE A PRIORITY!");
            //  System.out.println("Priority queue - "+QueueOfPensioneers.queueOfPensioneers);
        } else {
            QueueToCashier.queueToCashier.add(this);
            //    System.out.println(this+" stands in the queue");}


            //  System.out.println("Common queue - "+QueueToCashier.queueToCashier);
            synchronized (this) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void goOut(){
      //  System.out.println(this + "has come out the shop");
        Runner.currentNumberOfBuyers.getAndAdd(-1);


    }

    @Override
    public void takeBasket() {
        try {
            int pause =(int)( Rnd.fromTo(100,200)*(pensioner ? 1.5 : 1));
            Thread.sleep(pause);
        }
        catch (InterruptedException e){
            System.out.println(this+ " //некорректное завершение ожидания");
        }
       // System.out.println(this +"has taken a basket");
    }




    @Override
    public void putGoodsToBasket() {
        try{


            int pause = (int)(Rnd.fromTo(100, 200)*(pensioner ? 1.5 : 1));
            Thread.sleep(pause);



        }
        catch (InterruptedException e){
            System.out.println(this+ " //некорректное завершение ожидания");
        }
      //  System.out.println(this +"has put goods in the basket");
    }







    }


