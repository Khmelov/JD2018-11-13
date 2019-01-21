package by.it.nickgrudnitsky.jd02_09;

import by.it.nickgrudnitsky.jd02_09.beans.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TaskA {
    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(Twitch.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        FileReader fileReader = new FileReader("src/by/it/nickgrudnitsky/jd02_09/twitch+xsd.xml");
        System.out.println("XML-файл прочитан:");
        Twitch twitch = (Twitch) unmarshaller.unmarshal(fileReader);
        System.out.println(twitch);

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(twitch, new File("src/by/it/nickgrudnitsky/jd02_09/resultA.xml"));

    }


}
