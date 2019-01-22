package by.it.skarpovich.jd02_09;
/* 1) Create beans using xjc.exe generate.bat or command line (C:\Users\mdcat\IdeaProjects\skarpovich\JD2018-11-13\src\by\it\skarpovich\jd02_09>xjc -d
C:\Users\mdcat\IdeaProjects\skarpovich\JD2018-11-13\src buyers.xsd)
*/

import by.it.skarpovich.jd02_09.beans.Buyers;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.*;
import java.io.File;

public class TaskB {
    private static String fileName = System.getProperty("user.dir") + "/src/by/it/skarpovich/jd02_09/buyers.xml";
    private static String toXML = System.getProperty("user.dir") + "/src/by/it/skarpovich/jd02_09/resultB.xml";
    private static JAXBContext jaxbContext;
    private static GsonBuilder gsonBuilder;
    private static Buyers buyers;

    public static void main(String[] args) {
        try {
            readXml();  // Получаем объект (bean) класса Buyers из XML (unmarshall-инг)
            getJson();  // Получаем JSON(текст) из (bean) класса Buyers и возвращаем его в return
            readJson(getJson()); // Обратно получаем (bean) из JSON(принимаем на вход из getJson) и возвращаем его в return.

            checker(readJson(getJson())); // Проверяем начальный bean(buyers) с bean после конвертаций (buyersFromJson), принимая его на вход из readJson.
            saveXml(); // Получаем XML-файл из (bean) (ссылки) на объект buyers  (marshall-инг)


        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static void readXml() throws JAXBException {
        System.out.println("====================FROM XML====================");
        jaxbContext = JAXBContext.newInstance(Buyers.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        buyers = (Buyers) unmarshaller.unmarshal(new File(fileName));
        System.out.println(buyers);

    }


    private static String getJson() {
        System.out.println("====================FROM BEAN TO JSON=====================");
        gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.serializeNulls().setPrettyPrinting().create();
        String jsonText = gson.toJson(buyers);
        System.out.println(jsonText);
        return jsonText;
    }


    private static Buyers readJson(String Json) {
        System.out.println("====================FROM JSON TO BEAN=====================");
        gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.serializeNulls().setPrettyPrinting().create();
        Buyers buyersFromJson = gson.fromJson(Json, Buyers.class);

        return buyersFromJson;
    }

    private static void checker(Buyers buyersConverted) {
        if (buyersConverted.toString().equals(buyers.toString())) {
            System.out.println("CHECK OK!!!!");
        }
    }

    private static void saveXml() throws JAXBException {
        System.out.println("====================TO XML======================");
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(buyers, System.out);
        marshaller.marshal(buyers, new File(toXML));
    }
}



