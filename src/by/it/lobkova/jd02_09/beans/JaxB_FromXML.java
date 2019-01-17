package by.it.lobkova.jd02_09.beans;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JaxB_FromXML {
    public static void main(String[ ] args) {
        try {

            JAXBContext jc = JAXBContext.newInstance(Persons.class);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader("src/by/it/lobkova/jd02_09/person+xsd.xml");
            System.out.println("XML-файл прочитан:");
            Persons persons = (Persons) u.unmarshal(reader);
            System.out.println(persons);

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

