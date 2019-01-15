package by.it._examples_.jd02_09.manual;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JaxB_02_FromXML {
        public static void main(String[ ] args) {
            try {

                JAXBContext jc = JAXBContext.newInstance(Students.class);
                Unmarshaller u = jc.createUnmarshaller();
                FileReader reader = new FileReader("src/by/it/_examples_/jd02_09/manual/xml_01.xml");
                System.out.println("XML-файл прочитан:");
                Students students = (Students) u.unmarshal(reader);
                System.out.println(students);

            } catch (JAXBException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }