package by.it._examples_.jd02_06.p03_abstract_factory.factory.impl;

import by.it._examples_.jd02_06.p03_abstract_factory.factory.interfaces.TransportFactory;
import by.it._examples_.jd02_06.p03_abstract_factory.transport.impl.aircraft.Boeing747;
import by.it._examples_.jd02_06.p03_abstract_factory.transport.impl.car.Porsche;
import by.it._examples_.jd02_06.p03_abstract_factory.transport.interfaces.Aircraft;
import by.it._examples_.jd02_06.p03_abstract_factory.transport.interfaces.Car;

// американские транспортные средства
public class USAFactory implements TransportFactory{
    @Override
    public Car createCar() {
        return new Porsche();
    }

    @Override
    public Aircraft createAircraft() {
        return new Boeing747();
    }

}
