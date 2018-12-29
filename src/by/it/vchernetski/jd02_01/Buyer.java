package by.it.vchernetski.jd02_01;

class Buyer extends Thread implements IBuyer, IUseBacket {
    private Backet backet;
    private boolean pensioneer;
    private static int numOfBuyers=0;
    private static Object monitor = new Object();

    Buyer(int number) {
        super("Buyer №" + number);
        backet = new Backet();
        pensioneer = Math.random()<0.25;
        synchronized (monitor){
            numOfBuyers++;
        }
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
        synchronized (monitor){
            numOfBuyers--;
        }
        System.out.println(this + "go out from market.");
    }

    @Override
    public String toString() {
        if(pensioneer) return getName() + " pensioneer: ";
        else return getName() + ": ";
    }
    public static int getNumOfBuyers(){
        synchronized (monitor){
        return numOfBuyers;
        }
    }
}
