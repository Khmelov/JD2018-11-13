package by.it.lobkova.jd02_02;

public class Buyer extends Thread implements IBuyer, IUseBacket {

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    private Basket basket;

    Buyer(int number) {
        super("Buyer № " + number);
        Dispatcher.addBuyer();
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodsToBacket();
        goToQueue();
        Market.basketList.add(putBasket());
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter to market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " started to choose goods");
        int time = Util.random(500, 2000);
        Util.sleep(time);
        int goodCount = Util.random(1, 4);

        for (int i = 0; i < goodCount; i++) {
            basket.goods.add(Market.goodList.get(Util.random(Market.goodList.size() - 1)));
        }

        String strGoods = "";

        for (Good d: basket.goods) {
            strGoods += (d.id + " ");
        }

        System.out.println(this + " choose " + strGoods);
    }

    @Override
    public void goToQueue() {
        QueueBuyer.add(this);
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
        Dispatcher.removeBuyer();
        System.out.println(this + " go out from market");
    }

    @Override
    public String toString() {
        return getName() + ": ";
    }

    @Override
    public void takeBacket() {
        if (Market.basketList.isEmpty()) {
            Market.giveSomeBaskets();
        }
        Basket randomBasket = Market.basketList.get(Util.random(0, Market.basketList.size() - 1));
        Market.basketList.remove(randomBasket);
        basket = randomBasket;
        int time = Util.random(100, 200);
        Util.sleep(time);
        System.out.println(this + " take backet");
    }

    @Override
    public void putGoodsToBacket() {
        int time = Util.random(100, 200);
        Util.sleep(time);
        System.out.println(this + " put the goods in the basket");
    }

    @Override
    public Basket putBasket() {
        basket.goods.clear();
        return basket;
    }
}
