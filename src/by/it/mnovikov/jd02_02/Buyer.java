package by.it.mnovikov.jd02_02;

public class Buyer extends Thread implements IBuyer {

    Buyer(int buyerNum) {
        super("Покупатель №" + buyerNum);
        Dispatcher.addBuyer();
    }

    @Override
    public void run() {
        enterToMarket();
//        takeBacket();
        chooseGoods();
//        putGoodsToBacket();
        goToQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " вошёл в магазин");
    }

//    @Override
//    public void takeBacket() {
//        Util.sleepTime(100, 200);
//        System.out.println(this + " взял корзинку");
//    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " начал выбор товара");
        int timeout = Util.random(500, 2000);
        Util.sleep(timeout);
        System.out.println(this + " выбрал товар.");
    }

//    @Override
//    public void putGoodsToBacket() {
//        int countGoods = Util.random(1, 4);
//        for (int i = 0; i < countGoods; i++) {
//            int position = Util.random(0, Goods.goods.size() - 1);
//            Goods.getPosition(Goods.goods, position);
//            Util.sleepTime(100, 200);
//        }
//        System.out.println(this + " положил товары в корзинку");
//    }

    @Override
    public void goToQueue() {
        System.out.println(this + " пошёл на кассу.");
        QueueBuyer.add(this);
        synchronized (this){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void goOut() {
        System.out.println(this + " вышел из магазина");
        Dispatcher.removeBuyer();
    }

    @Override
    public String toString() {
        return getName() + ": ";
    }

}

