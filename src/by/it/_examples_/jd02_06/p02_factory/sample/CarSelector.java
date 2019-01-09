package by.it._examples_.jd02_06.p02_factory.sample;

// фабрика по созданию автомобилей
class CarSelector {
    
    // фабричный метод, который создает нужный автомобиль
    Car getCar(RoadType roadType) {
        Car car = null;
        switch (roadType) {
            case CITY:
                car = new Mercedes();
                break;
            case OFF_ROAD:
                car = new Geep();
                break;
            case ROAD:
                car = new Crossover();
                break;
        }

        return car;
    }
}
