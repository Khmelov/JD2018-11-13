package by.it.seroglazov.jd02_02;

import java.util.LinkedList;

// Класс очередь
class WaitingLine {

    private LinkedList<Buyer> line;

    WaitingLine(){
        line = new LinkedList<>();
    }
    void add(Buyer buyer){
        line.addLast(buyer);
    }

    Buyer next(){
        return line.pollFirst();
    }

}
