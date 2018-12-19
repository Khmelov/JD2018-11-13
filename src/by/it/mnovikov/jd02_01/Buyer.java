package by.it.mnovikov.jd02_01;

public class Buyer extends Thread implements IBuyer, IUseBacket{

    int buyerNum;

    public Buyer (int buyerNum){
        this.buyerNum = buyerNum;
        this.setName("Покупатель № " + buyerNum + " ");
        start();
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goOut();
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " вошёл в магазин");
    }

    @Override
    public void takeBacket() {

    }

    @Override
    public void chooseGoods() {
        try {
            int pause = Rnd.random(500,2000);
            Thread.sleep(pause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void putGoodsToBacket() {

    }

    @Override
    public void goOut() {
        System.out.println(this + " вышел из магазина");
    }
}
