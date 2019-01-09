package by.it._examples_.jd02_06.p03_abstract_factory.transport.impl.car;

import by.it._examples_.jd02_06.p03_abstract_factory.transport.interfaces.Car;

public class Maz implements Car {
    @Override
    public void drive() {
        System.out.println("Maz drive");
    }

    @Override
    public void stop() {
        System.out.println("Maz stopped");
    }
    
}
