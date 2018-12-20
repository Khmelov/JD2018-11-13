package by.it.skarpovich.j02_01;

class Buyer extends Thread implements IBuyer, IUseBasket {
   Buyer (int number) {
       super("Buyer №" + number);
   }
    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+"entered to the market");
    }
    @Override
    public void takeBasket() {
        int timeout=Util.random(100, 200);
        Util.sleep(timeout);
        System.out.println(this+"took a basket");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this+"started to choose goods");
        int timeout=Util.random(500, 2000);
        Util.sleep(timeout);
        //yield(); -ask
        System.out.println(this + "chose goods");
    }


    @Override
    public void putGoodsToBasket() {
        int timeout=Util.random(100, 200);
        Util.sleep(timeout);
        int goodsCount=Util.random(1, 4);  // Получаем случайное количество товаров от 1 до 4-х.
        // Выводим количество товаров и результат(список случайных покупок с ценами) из метода goods
        System.out.println(this+"put " + goodsCount+ " good(s) in the basket: " +Util.goods(goodsCount));


    }
    @Override
    public void goOut() {
        System.out.println(this+"left the market");
    }

    @Override
    public String toString() {return  getName()+": ";}
}
