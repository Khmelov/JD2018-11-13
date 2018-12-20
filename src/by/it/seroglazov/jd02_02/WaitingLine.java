package by.it.seroglazov.jd02_02;

import java.util.LinkedList;

// Класс очередь
class WaitingLine {

    private LinkedList<Buyer> line;

    WaitingLine(){
        line = new LinkedList<>();
    }

    int add(Buyer buyer){
        line.addLast(buyer);
        return line.size();
    }

    Buyer next(){
        return line.pollFirst();
    }

    int length(){
        return line.size();
    }

}
