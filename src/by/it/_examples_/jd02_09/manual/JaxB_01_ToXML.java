package by.it._examples_.jd02_09.manual;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
public class JaxB_01_ToXML {
    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Students.class);
            Marshaller m = context.createMarshaller();
            Students st = new Students() { // анонимный класс
                {
                    // добавление первого студента
                    Student.Address addr = new Student.Address("BLR", "Minsk", "Lenina 7");
                    Student s = new Student("uvik", "Migov", "Uvik", "poit", 1234567, addr);
                    this.add(s);
                    // добавление второго студента
                    addr = new Student.Address("BLR", "Grodno", "Harna 23");
                    s = new Student("muvik", "Kurin", "Muvik","poit", 7654321, addr);
                    this.add(s);
                }
            };
            m.marshal(st, new FileOutputStream("src/by/it/_examples_/jd02_09/manual/xml_01.xml"));
            System.out.println("XML-файл создан");
            m.marshal(st, System.out); // копия на консоль
        } catch (FileNotFoundException e) {System.out.println("XML-файл не может быть создан: " + e);}
          catch (JAXBException e) {        System.out.println("JAXB-контекст ошибочен " + e);        }
    }
}