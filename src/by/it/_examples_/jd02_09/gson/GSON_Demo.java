package by.it._examples_.jd02_09.gson;

//для корректной работы добавьте библиотеку
//File, Project Structure, Libraries,  Кнопка + , maven, com.google.gson

//или подключите ее локально, если она есть в папке lib общего репозитория
//File, Project Structure, Libraries,  Кнопка + , Java, lib, gson-2.7.jar

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GSON_Demo {

    public static void main(String[] args) {
        //маршаллизация и демаршаллизация в/из JSON. Подготовим  обработчики.
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        /* Строка выше это кратко. Создадим еще один точно такой же обработчик json
        GsonBuilder builder = new GsonBuilder(); //Это строитель
        builder=builder.serializeNulls();        //в нем пишем что сериализуются null
        builder=builder.setPrettyPrinting();     //и вывод будет форматированный
        Gson gson=builder.create();              //теперь строитель строит того же обработчика
        */

        // Создаем объект для тестов
        String[] skills={"java","gson","json"};
        Dev dev=new Dev("Ivanov",skills);
        //маршаллизация
        String json = gson.toJson(dev);
        System.out.print(json);
        //демаршаллизация
        Dev dev2=gson.fromJson(json, Dev.class);
        System.out.print("\n\ndev2=" + dev2.toString());
    }
}


