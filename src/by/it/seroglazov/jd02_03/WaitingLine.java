package by.it.seroglazov.jd02_03;

import java.util.concurrent.LinkedBlockingDeque;

// Класс очередь
class WaitingLine {

    private LinkedBlockingDeque<Buyer> allLine;
    private LinkedBlockingDeque<Buyer> pensLine;

    // Пустой покупатель заглушка - означает, что на этом месте стоит пенсионер и надо брать из очереди где пенсионеры первого
    // Это нужно чтобы фиксированный размер очереди сохранялся
    private static final Buyer bPens = new Buyer();

    WaitingLine(int size) {
        allLine = new LinkedBlockingDeque<>(size);
        pensLine = new LinkedBlockingDeque<>();
    }

    int add(Buyer buyer) {
        try {
            if (buyer.isPensioneer()) {
                pensLine.addLast(buyer); // Добавить его последним в очередь пенсионеров
                allLine.putFirst(bPens); // Добавить объект-заглушку в основную очередь
            } else {
                allLine.putLast(buyer);
            }
        } catch (InterruptedException e) {
            System.err.println("InterruptedException " + e.getMessage());
        }
        return allLine.size();
    }

    Buyer next() {
        Buyer b = allLine.pollFirst();
        if (b == bPens) return pensLine.pollFirst(); // Если был объект заглушка - вернуть первого пенсионера из очереди
        return b;
    }

    int length() {
        return allLine.size();
    }

}
