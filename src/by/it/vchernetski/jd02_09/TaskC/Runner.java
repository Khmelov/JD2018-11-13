package by.it.vchernetski.jd02_09.TaskC;

import by.it.vchernetski.jd02_09.beans.Drivers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Runner {
    private static String path = System.getProperty("user.dir") + "/src/by/it/vchernetski/jd02_09/Drivers+xsd.xml";

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(path)))) {
            while (reader.ready()) {
                sb.append(reader.readLine()).append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("XML to Json");
        ConverterFactory factory = new ConverterFactory();
        Converter xmlToJson = factory.getConverter(Direction.XML_TO_JSON, Drivers.class);
        xmlToJson.load(new File(path));//получили bean
        String js = xmlToJson.getText();//получили текстовое представление
        System.out.println(js);
        xmlToJson.clearBean();//пересоздали bean
        System.out.println("Json to XML");
        Converter jsonToXML = factory.getConverter(Direction.JSON_TO_XML,Drivers.class);
        jsonToXML.load(js);//получили bean
        String as = jsonToXML.getText();
        System.out.println(as);
        jsonToXML.save(new File(System.getProperty("user.dir") + "/src/by/it/vchernetski/jd02_09/TaskC/finXML.xml"));
    }
}
