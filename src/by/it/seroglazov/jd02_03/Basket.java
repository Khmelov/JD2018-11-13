package by.it.seroglazov.jd02_03;


import java.util.LinkedList;

class Basket {

    private LinkedList<String> goods;

    Basket(){
        goods = new LinkedList<>();
    }

    void putGoodToBasket(String name){
        goods.add(name);
    }

    String takeGoodFromBasket(){
        return goods.pollLast();
    }

    int goodsCount(){
        return goods.size();
    }
}
