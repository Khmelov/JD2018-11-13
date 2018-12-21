package by.it.lobkova.jd02_02;

public interface IBuyer {

    void enterToMarket(); //вошел в магазин (мгновенно)
    void chooseGoods(); //выбрал товар (от 0,5 до 2 секунд)
    void goOut();

}
