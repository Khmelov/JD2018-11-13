package by.it._examples_.jd02_06.p03_abstract_factory.factory.interfaces;

import by.it._examples_.jd02_06.p03_abstract_factory.transport.interfaces.Aircraft;
import by.it._examples_.jd02_06.p03_abstract_factory.transport.interfaces.Car;

// фабрика по созданию транспортных средств
public interface TransportFactory { // что фабрика будет производить
    Car createCar();// автомобили
    Aircraft createAircraft(); // самолеты

}
