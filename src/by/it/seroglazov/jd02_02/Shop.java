package by.it.seroglazov.jd02_02;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

// Класс Shop - в нашем проекте будет один экземпляр этого класса. Создаётся в Runner.
// За всю синхронизацию отвечает именно магазин

public class Shop {
    // Список товаров
    private final HashMap<String, Double> goods;
    // Покупатели, которые находятся в магазине
    private final HashSet<Buyer> buyers;
    // Очередь
    private final WaitingLine line;

    Shop() {
        goods = new HashMap<>();
        buyers = new HashSet<Buyer>();
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

    // Return random good from goods
    String takeSomeGood() {
        synchronized (goods) {
            int num = MyRandom.getRandom(0, goods.size() - 1);
            Iterator<String> it = goods.keySet().iterator();
            for (int i = 0; i < num; i++) {
                it.next();
            }
            return it.next();
        }
    }

    // Войти в магазин
    int enter(Buyer buyer) {
        synchronized (buyers) {
            buyers.add(buyer);
            return buyers.size();
        }
    }

    // Выйти из магазина
    int leave(Buyer buyer) {
        synchronized (buyers) {
            buyers.remove(buyer);
            return buyers.size();
        }
    }

    int buyersCount() {
        synchronized (buyers) {
            return buyers.size();
        }
    }

    // Встать в очередь
    int putBuyerInLine(Buyer buyer) {
        synchronized (line) {
            return line.add(buyer);
        }
    }

    // Возвращает первого в очереди покупателя или null, если очередь пуста
    Buyer getBuyerFromLine() {
        synchronized (line) {
            return line.next();
        }
    }

    // Сколько людей в очереди
    int lineLength(){
        synchronized (line) {
            return line.length();
        }
    }
}
