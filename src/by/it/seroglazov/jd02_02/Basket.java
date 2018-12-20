package by.it.seroglazov.jd02_02;


import java.util.LinkedList;

public class Basket {

    private LinkedList<String> goods;

    public Basket(){
        goods = new LinkedList<>();
    }

    public void putGoodToBasket(String name){
        goods.add(name);
    }

    public String takeGoodFromBasket(){
        return goods.pollLast();
    }
}
