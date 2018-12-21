package by.it.vchernetski.jd02_01;


import java.util.concurrent.CopyOnWriteArraySet;

class Buyer extends Thread implements IBuyer, IUseBacket {
    private Backet backet;
    private boolean pensioneer;
    static CopyOnWriteArraySet<Buyer> buyers=new CopyOnWriteArraySet<>();

    Buyer(int number) {
        super("Buyer №" + number);
        backet = new Backet();
        pensioneer = Math.random()<0.25;
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
    public void enterToMarket() {
        System.out.println(this + "enter to market.");
        buyers.add(this);
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "started to choose goods");
        int timeout = Util.random(500, 2000);
        if(pensioneer) Util.sleep(timeout*3/2);
        else Util.sleep(timeout);
        System.out.println(this + "choosed goods.");
    }

    @Override
    public void takeBacket() {
        int timeout = Util.random(500, 2000);
        if(pensioneer) Util.sleep(timeout*3/2);
        else Util.sleep(timeout);
        System.out.println(this+"take a backet");
    }

    @Override
    public void putGoodsToBacket() {
        int timeout = Util.random(500, 2000);
        int numOfGoods = Util.random(1,4);
        for (int i = 0; i < numOfGoods; i++) {
            if(pensioneer) Util.sleep(timeout*3/2);
            else Util.sleep(timeout);
            System.out.println(this+backet.putGood());
        }
    }

    @Override
    public void goOut() {
        buyers.remove(this);
        System.out.println(this + "go out from market.");
    }

    @Override
    public String toString() {
        if(pensioneer) return getName() + " pensioneer: ";
        else return getName() + ": ";
    }
}
