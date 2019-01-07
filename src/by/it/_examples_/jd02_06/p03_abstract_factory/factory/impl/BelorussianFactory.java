package by.it._examples_.jd02_06.p03_abstract_factory.factory.impl;

import by.it._examples_.jd02_06.p03_abstract_factory.factory.interfaces.TransportFactory;
import by.it._examples_.jd02_06.p03_abstract_factory.transport.impl.aircraft.TU134;
import by.it._examples_.jd02_06.p03_abstract_factory.transport.impl.car.Maz;
import by.it._examples_.jd02_06.p03_abstract_factory.transport.interfaces.Aircraft;
import by.it._examples_.jd02_06.p03_abstract_factory.transport.interfaces.Car;

// российские транспортные средства
public class BelorussianFactory implements TransportFactory{

    @Override
    public Car createCar() {
        return new Maz();
    }

    @Override
    public Aircraft createAircraft() {
        return new TU134();
    }

}
