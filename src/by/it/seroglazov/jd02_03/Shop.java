package by.it.seroglazov.jd02_03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Класс Shop - в нашем проекте будет один экземпляр этого класса. Создаётся в Runner.
// За всю синхронизацию отвечает именно магазин
// Чтобы войти в него покупатель вызывает enter, чтобы выйти leave
// Если корзина не пуста, то уже можешь сам выйти через leave,
// только через постановку в очередь в кассу и расчет.
class Shop {
    // Список товаров
    private final HashMap<String, Double> goods;
    // Покупатели, которые находятся в магазине
    private final ConcurrentHashMap<Buyer, Basket> buyers; // Надо брать монитор при обращении
    // Очередь
    private final WaitingLine waitingLine;
    // Сколько людей вошло в магазин за время его работы
    private int bCounter = 0;
    // Магазин работает пока не впустит запланированное количество посетителей
    private final int buyersCountPlan = 100;
    // Если true - магазин больше не пускает посетителей и закроется как только последний выйдет.
    private boolean closing = false;
    // Последний покупатель вышел - магазин закрыт
    private boolean closedShop = false;
    // Это маркер отсутсвие корзины у покупателя. Чтобы не null писать в HashMap<Buyer, Basket>
    private final Basket absentBasket = new Basket();
    // Количество кассиров
    private static final int CASHIERS_COUNT = 5;
    // Кассиры
    private final ArrayList<Cashier> cashiers = new ArrayList<>();
    private final ExecutorService cashExecService;
    // Менеджер. Управляет кассирами.
    private Manager manager;
    private double totalCash = 0;
    private static final Object outputMonitor = new Object();

    Shop() {
        goods = new HashMap<>();
        buyers = new ConcurrentHashMap<>();
        waitingLine = new WaitingLine(30);
        goods.put("Мясо", 10.0);
        goods.put("Сало", 6.5);
        goods.put("Колбаса", 7.6);
        goods.put("Майонез", 2.2);
        goods.put("Батон", 1.0);
        goods.put("Хлеб", 1.1);
        goods.put("Молоко", 3.7);
        goods.put("Штаны", 25.7);
        goods.put("Шапка", 15.4);
        goods.put("Куртка", 48.2);
        goods.put("Карандаш", 0.3);
        goods.put("Гвозди", 5.5);
        if (Runner.TABLE_MODE) printTitleLine();
        /*
        for (int i = 0; i < CASHIERS_COUNT; i++) {
            cashiers.add(new Cashier(i + 1, this));
        }*/
        cashExecService = Executors.newFixedThreadPool(CASHIERS_COUNT);
        for (int i = 0; i < CASHIERS_COUNT; i++) {
            Cashier c = new Cashier(i + 1, this);
            cashiers.add(c);
            cashExecService.execute(c);
        }
        cashExecService.shutdown();
        manager = new Manager(this);
    }

    // Ложит Count случайных товаров в карзину покупателя
    // Возвращает списко этих товаров
    String[] putRandomGoodsToBasket(Buyer buyer, int count) {
        String[] g = new String[count];
        synchronized (goods) {
            for (int i = 0; i < count; i++) {
                int num = MyRandom.getRandom(0, goods.size() - 1);
                Iterator<String> it = goods.keySet().iterator();
                for (int j = 0; j < num; j++) it.next(); // Пропускаем num-1 элементов
                g[i] = it.next(); // Берем num элемент
            }
        }
        // Если buyer в магазине, ложим в его корзину товары
        Basket basket = buyers.get(buyer);
        if (basket != null) {
            for (int i = 0; i < count; i++) {
                basket.putGoodToBasket(g[i]);
            }
            return g;
        } else return null;
    }

    // Войти в магазин. Если пустили в магазин, то возвращается количество людей в магазине ( с учетом нового buyer)
    // Если не пустили, то вернет -1
    int enter(Buyer buyer) {
        if (!closing) {
            buyers.put(buyer, absentBasket); // Пока без корзины, поэтому absentBasket
            if (++bCounter >= buyersCountPlan) closing = true;
            return buyers.size();
        } else return -1;
    }

    boolean isClosedShop() {
        return closedShop;
    }

    // Выйти из магазина. Если выпустили из магазина, то возвращается количество людей оставшихся в магазине
    // Если нет такого покупателя в магазине вернёт -1; Если не выпустили вернет -2,
    int leave(Buyer buyer) {
        Basket b = buyers.get(buyer);
        if (b != null) {    // Если покупатель в магазине
            if (b == absentBasket) {   // Если он без корзины - выпускаем из магазина
                buyers.remove(buyer);
                int s = buyers.size();
                if (closing && s == 0)
                    closedShop = true;  // Магазин закрывался и последний покупать вышел
                return s;
            } else {
                if (b.goodsCount() == 0) { // Если корзина есть, но в ней нет товара, то выпускаем
                    buyers.remove(buyer);
                    int s = buyers.size();
                    if (closing && s == 0)
                        closedShop = true; // Магазин закрывался и последний покупать вышел
                    return s;
                } else {
                    return -2; // Если есть товары в корзине, то не выпускаем - должен становится в очередь
                }
            }
        } else return -1;

    }

    // Отпустить персонал
    void freePersonal(Manager m) {
        if (m == manager) { // Только наш менеджер может отпустить персонал*for (Cashier cashier : cashiers) {
            // Отпускаем кассиров
            for (Cashier cashier : cashiers) {
                cashier.endOfWorkDay();
            }
            // Даем им 1 секунду, чтоб добровольно свалить
            try {
                cashExecService.awaitTermination(1000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                System.err.println("InterruptedException " + e.getMessage());
            }
            // Если кто-то не свалил, всех закрываем силой
            if (!cashExecService.isTerminated())
                cashExecService.shutdownNow();
            /*cashiers.forEach(x -> {
                Thread th = x.getThread();
                try {
                    while (th.isAlive()) {
                        th.join(10);
                        x.endOfWorkDay();
                    }
                } catch (InterruptedException e) {
                    System.err.println("InterruptedException " + e.getMessage());
                }
            });*/
            // Отпускаем себя самого
            manager.endOfWorkDay();
        }
    }

    // Сколько людей сейчас находится в магазине
    int buyersCount() {
        return buyers.size();
    }

    // Встать в очередь. Только если buyer находится в магазине
    // Возвращает число людей в очереди. -1 покупатель не в магазине
    int getInLine(Buyer buyer) {
        if (buyerInside(buyer)) { // Если покупатель в магазине
            return waitingLine.add(buyer);
        }
        return -1;
    }

    // Возвращает первого в очереди покупателя или null, если очередь пуста
    Buyer takeFromLine() {
        return waitingLine.next();
    }

    // Сколько людей в очереди
    int lineLength() {
        return waitingLine.length();
    }

    // Взять корзину. Только если buyer находится в магазине и у него нет корзины
    // Возвр true если покупателю дали корзину, иначе false
    boolean takeBasket(Buyer buyer) {
        Basket b = buyers.get(buyer);
        if (b == null) { // Если нет такого покупателя в магазине
            return false;
        } else if (b == absentBasket) {  // Если у покупателя нет корзинки
            buyers.put(buyer, new Basket()); // Создать корзину и связать её с покупателем
            return true;
        } else
            return false;
    }

    // Находится ли сейчас в магазине данный покупатель
    private boolean buyerInside(Buyer buyer) {
        return buyers.containsKey(buyer);
    }

    private int getNeededCashiersCount(int c) {
        if (c > 20) return 5;
        if (c > 15) return 4;
        if (c > 10) return 3;
        if (c > 5) return 2;
        if (c > 0) return 1;
        return 0;
    }

    // Эта проверка запускается менеджером
    // Только менджер этого магазина хранимый в поле manager может запустить эту проверку
    // Метод смотрит сколько людей в очереди, сколько нужно кассиров, и пробуждает отдыхающих
    // кассиров в случайном порядке пока их не станет столько сколько нужно
    void checkForCashiers(Manager m) {
        if (m == manager) { // Слушаемся только своего менеджера
            int count = lineLength(); // Столько покупателей в очереди
            int need = getNeededCashiersCount(count); // Столько кассиров должно быть
            int working = 0;
            for (Cashier cashier : cashiers) {
                if (!cashier.isWaiting()) working++;
            }
            if (need > working) {
                int[] ran = getRandomNomers(cashiers.size()); // Здесь храним случайный порядок кассиров
                for (int i = 0; i < cashiers.size(); i++) {
                    if (cashiers.get(ran[i]).wakeUp()) {
                        if (Runner.FULL_LOG) System.out.println("Менеджер открыл " + cashiers.get(ran[i]));
                        if (++working == need) break;
                    }
                }
            }
        }
    }

    // Возвращает массив размера length заполненный случайными числами от 0 до length-1
    // причем ни одно число не повторяется
    private int[] getRandomNomers(int length) {
        List<Integer> list = new ArrayList<>(length);
        boolean add;
        while (list.size() < length) {
            add = false;
            Integer v = (int) (Math.random() * length);
            while (!add) {
                if (!list.contains(v)) {
                    list.add(v);
                    add = true;
                } else {
                    v++;
                    if (v >= length) v = 0;
                }
            }
        }
        int[] r = new int[length];
        for (int i = 0; i < length; i++) {
            r[i] = list.get(i);
        }
        return r;
    }

    // Рассчитать покупателя
    void check(Buyer b, Cashier c, int lineLength) {
        Basket bas;
        bas = buyers.get(b);
        String good = bas.takeGoodFromBasket();
        List<String> output = new ArrayList<>();
        double fullSum = 0;
        while (good != null) {
            double money = goods.get(good);
            if (Runner.FULL_LOG)
                System.out.println(c + " взял с " + b.getShortName() + " " + money + " рублей за " + good);
            if (Runner.TABLE_MODE) output.add(getTableLine(c, good, money, lineLength, false));
            fullSum += money;
            good = bas.takeGoodFromBasket();
        }

        if (Runner.FULL_LOG)
            System.out.println("Итого " + b.getShortName() + " оставил в магазине " + fullSum + " рублей.");
        if (Runner.TABLE_MODE) output.add(getTableLine(c, "Итого:", fullSum, lineLength, true));
        synchronized (outputMonitor) {
            output.forEach(System.out::println);
        }
    }

    private String getTableLine(Cashier c, String good, Double money, int lineLength, boolean flag) {
        int n = c.getNomer() - 1;
        int w = Runner.CHARR_IN_COLUMN;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < CASHIERS_COUNT; i++) {
            if (i == n) {
                sb.append(String.format(" %" + (w - 9) + "s %6.2f ", good, money)).append('|');
            } else {
                sb.append(Runner.EMPTY_COL).append('|');
            }
        }

        if (flag) {
            sb.append(String.format(" Очередь: %" + (w - 10) + "d", lineLength)).append('|');
            sb.append(String.format(" Итого: %" + (w - 9) + ".2f ", addCash(money))).append('|');
        } else {
            sb.append(Runner.EMPTY_COL).append('|');
            sb.append(Runner.EMPTY_COL).append('|');
        }
        return sb.toString();
    }

    private static void printTitleLine() {
        int w = Runner.CHARR_IN_COLUMN;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < CASHIERS_COUNT; i++) {
            sb.append(String.format("%" + (w - 3) + "s%d  ", "касса N", i + 1)).append('|');
        }
        System.out.println(sb);
    }

    private synchronized double addCash(double d) {
        return totalCash += d;
    }
}
