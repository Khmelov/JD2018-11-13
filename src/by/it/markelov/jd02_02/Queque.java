package by.it.markelov.jd02_02;

import java.util.LinkedList;

public class Queque {
    public static LinkedList<Buyer> quequeBuyers = new LinkedList<>();
    public static LinkedList<Buyer> quequePensionners = new LinkedList<>();

    String name;

    public Queque(String name) {
        this.name = name;
    }

    public String getName() {
     return name;
    }
}
