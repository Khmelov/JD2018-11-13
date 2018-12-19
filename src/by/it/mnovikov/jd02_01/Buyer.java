package by.it.mnovikov.jd02_01;

public class Buyer extends Thread implements IBuyer, IUseBacket{

    Buyer (int buyerNum){ super("Покупатель № " + buyerNum + " ");
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodsToBacket();
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
        try {
            int pause = Rnd.random(100, 200);
            Thread.sleep(pause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this + " взял корзинку");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " начал выбор товара");
        try {
            int pause = Rnd.random(500, 2000);
            Thread.sleep(pause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this + " выбрал товар");
    }

    @Override
    public void putGoodsToBacket() {
        try {
            int pause = Rnd.random(100, 200);
            Thread.sleep(pause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this + " положил товары в корзинку");
    }

    @Override
    public void goOut() {
        System.out.println(this + " вышел из магазина");
    }
}
