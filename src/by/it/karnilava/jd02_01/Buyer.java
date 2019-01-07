package by.it.karnilava.jd02_01;



public class Buyer extends Thread implements Runnable, IBuyer, IUseBasket {
    int num; // номер покупателя
    boolean pensioner;

    //консруктор покупателя с его номером
    public Buyer(int num, boolean pensioneer) {
        this.num = num;
        this.setName("Buyer # "+num+" ");
        this.pensioner = pensioneer;
        start();
    }

    @Override // покупатель приходит в зал и выбирает продукты
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goOut();
    }

    public String toString() {
        return this.getName();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "has come to the shop");
    }

    @Override
    public void chooseGoods() {
        try {
            int quantityOfGoods = Rnd.fromTo(1,4);
            for (int i = 0; i <quantityOfGoods ; i++) {
                int pause = (int)(Rnd.fromTo(500, 2000)*(pensioner ? 1.5 : 1));
                Thread.sleep(pause);
                int productOfChoice = Rnd.fromTo(1,4);
               int value = ListOfGoods.listOfGoods.get(productOfChoice);
                System.out.println(this+" want product#"+productOfChoice+", value -"+value);

            }
        }
        catch (InterruptedException e){
            System.out.println(this+ " //некорректное завершение ожидания");
        }
        System.out.println(this +"has chosen goods");
    }

    @Override
    public void goOut() {
        System.out.println(this + "has come out the shop");
        Runner.countBuyers--;

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
        System.out.println(this +"has taken a basket");
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
        System.out.println(this +"has put goods in the basket");
    }


    }

