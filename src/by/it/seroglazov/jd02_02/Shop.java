package by.it.seroglazov.jd02_02;

import java.util.HashMap;
import java.util.Iterator;

// Класс Shop - в нашем проекте будет один экземпляр этого класса. Создаётся в Runner.
// За всю синхронизацию отвечает именно магазин
// Чтобы войти в него покупатель вызывает enter, чтобы выйти leave
// Если корзина не пуста, то уже можешь сам выйти через leave,
// только через постановку в очередь в кассу и расчет.
class Shop {
    // Список товаров
    private final HashMap<String, Double> goods;
    // Покупатели, которые находятся в магазине
    private final HashMap<Buyer, Basket> buyers; // Надо брать монитор при обращении
    // Очередь
    private final WaitingLine line;
    // Сколько людей вошло в магазин за время его работы
    private int bCounter = 0;
    // Магазин работает пока не впустит запланированное количество посетителей
    private final int buyersCountPlan = 200;
    // Если true - магазин больше не пускает посетителей и закроется как только последний выйдет.
    private boolean closing = false;
    // Это маркер отсутсвие корзины у покупателя. Чтобы не null писать в HashMap<Buyer, Basket>
    private final Basket absentBasket = new Basket();

    Shop() {
        goods = new HashMap<>();
        buyers = new HashMap<Buyer, Basket>();
        line = new WaitingLine();
        goods.put("Мясо", 10.0);
        goods.put("Сало", 6.5);
        goods.put("Колбаса", 7.6);
        goods.put("Майонез", 2.2);
        goods.put("Батон", 1.0);
        goods.put("Хлеб", 1.1);
        goods.put("Молоко", 3.7);
        goods.put("Штаны", 25.7);
        goods.put("Шапка", 15.4);
        goods.put("Куртка", 48.24);
        goods.put("Карандаш", 0.3);
        goods.put("Гвозди", 5.5);
    }

    // Ложит Count случайных товаров в карзину покупателя
    boolean putRandomGoodsToBasket(Buyer buyer, int count) {
        String[] g = new String[count];
        synchronized (goods) {
            for (int i = 0; i < count; i++) {
                int num = MyRandom.getRandom(0, goods.size() - 1);
                Iterator<String> it = goods.keySet().iterator();
                for (int j = 0; j < num; j++) it.next();
                g[i] = it.next();
            }
        }
        synchronized (buyers) {
            // Если buyer в магазине, ложим в его корзину товары
            Basket basket = buyers.get(buyer);
            if (basket != null) {
                for (int i = 0; i < count; i++) {
                    basket.putGoodToBasket(g[i]);
                }
                return true;
            } else return false;
        }
    }

    // Войти в магазин. Если пустили в магазин, то возвращается количество людей в магазине ( с учетом нового buyer)
    // Если не пустили, то вернет -1
    int enter(Buyer buyer) {
        if (!closing) {
            synchronized (buyers) {
                buyers.put(buyer, absentBasket); // Пока без корзины, поэтому absentBasket
                if (++bCounter >= buyersCountPlan) closing = true;
                return buyers.size();
            }
        } else return -1;
    }

    // Выйти из магазина. Если выпустили из магазина, то возвращается количество людей оставшихся в магазине
    // Если нет такого покупателя в магазине вернёт -1; Если не выпустили вернет -2,
    int leave(Buyer buyer) {
        synchronized (buyers) {
            Basket b = buyers.get(buyer);
            if (b != null) {    // Если покупатель в магазине
                if (b == absentBasket) {   // Если он без корзины - выпускаем из магазина
                    buyers.remove(buyer);
                    return buyers.size();
                }
                else {
                    if (b.goodsCount() == 0) { // Если корзина есть, но в ней нет товара, то выпускаем
                        buyers.remove(buyer);
                        return buyers.size();
                    } else {
                        return -2; // Если есть товары в корзине, то не выпускаем - должен становится в очередь
                    }
                }
            }
            else return -1;
        }
    }

    // Сколько людей сейчас находится в магазине
    int buyersCount() {
        synchronized (buyers) {
            return buyers.size();
        }
    }

    // Встать в очередь. Только если buyer находится в магазине
    // Возвращает число людей в очереди. -1 если не дали встать в очередь
    int getInLine(Buyer buyer) {
        if (buyerInside(buyer)) {
            synchronized (line) {
                return line.add(buyer);
            }
        }
        return -1;
    }

    // Возвращает первого в очереди покупателя или null, если очередь пуста
    private Buyer takeFromLine() {
        synchronized (line) {
            return line.next();
        }
    }

    // Сколько людей в очереди
    int lineLength() {
        synchronized (line) {
            return line.length();
        }
    }

    // Взять корзину. Только если buyer находится в магазине и у него нет корзины
    boolean takeBasket(Buyer buyer) {
        synchronized (buyers) {
            Basket b = buyers.get(buyer);
            if (b == null){ // Если нет такого покупателя в магазине
                return false;
            }else if (b == absentBasket) {  // Если у покупателя нет корзинки
                buyers.put(buyer, new Basket()); // Создать корзину и связать её с покупателем
                return true;
            } else
                return false;
        }
    }

    // Находится ли сейчас в магазине данный покупатель
    private boolean buyerInside(Buyer buyer) {
        synchronized (buyers) {
            return buyers.containsKey(buyer);
        }
    }
}
