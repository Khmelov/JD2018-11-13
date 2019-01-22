package by.it.nickgrudnitsky.jd02_09.taskC;

import by.it.nickgrudnitsky.jd02_09.beans.Twitch;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;

public class Runner {
    public static void main(String[] args) {
        try {
            Twitch twitch = new Twitch();
            File file = new File("/IT-Academy/JD2018-11-13/src/by/it/nickgrudnitsky/jd02_09/twitch+xsd.xml");
            ConverterFactory converterFactory = new ConverterFactory(twitch);

            Converter converter = converterFactory.getConverter(Direction.XML_TO_JSON);
            converter.load(file);
            String json = converter.getText();
            converter.save(new File("/IT-Academy/JD2018-11-13/src/by/it/nickgrudnitsky/jd02_09/taskC/taskC.json"));
            System.out.println(json);

            converter = converterFactory.getConverter(Direction.JSON_TO_XML);
            converter.load(json);
            String xml = converter.getText();
            converter.save(new File("/IT-Academy/JD2018-11-13/src/by/it/nickgrudnitsky/jd02_09/taskC/taskC.xml"));
            System.out.println(xml);
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }


    }
}
