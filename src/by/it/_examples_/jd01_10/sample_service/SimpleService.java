package by.it._examples_.jd01_10.sample_service;

@Service(name="Just simple Service")
public class SimpleService {

    @Init
    public void initialization(){
        System.out.println("Инициализация Just Service запущена");
    }

    public void  halt(){
        System.out.println("Just Service остановлен");
    }

    public SimpleService() {
        System.out.println("Создан экземпляр Just Service ");
    }
}
