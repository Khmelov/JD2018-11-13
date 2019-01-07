package by.it._examples_.jd02_06.p03_abstract_factory.transport.impl.aircraft;

import by.it._examples_.jd02_06.p03_abstract_factory.transport.interfaces.Aircraft;

public class TU134 implements Aircraft{
    @Override
    public void flight() {
        System.out.println("TU-134 flight!");
    }
}
