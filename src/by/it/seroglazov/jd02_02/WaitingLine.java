package by.it.seroglazov.jd02_02;

import java.util.LinkedList;

// Класс очередь
class WaitingLine {

    private LinkedList<Buyer> normLine; // Обычные
    private LinkedList<Buyer> pensLine; // Пенсионеры

    WaitingLine(){
        normLine = new LinkedList<>();
        pensLine = new LinkedList<>();
    }

    synchronized int add(Buyer buyer){
        if (buyer.isPensioneer()) {
            pensLine.addLast(buyer);
        } else {
            normLine.addLast(buyer);
        }
        return normLine.size() + pensLine.size();
    }

    synchronized Buyer next(){
        if (!pensLine.isEmpty()){
            return pensLine.pollFirst();
        } else {
            return normLine.pollFirst();
        }
    }

    synchronized int length(){
        return normLine.size() + pensLine.size();
    }

}
