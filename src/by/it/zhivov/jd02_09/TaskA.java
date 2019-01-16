package by.it.zhivov.jd02_09;


import by.it.zhivov.jd02_09.beans.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

public class TaskA {
    public static void main(String[] args) {
        String generatedXML = System.getProperty("user.dir") + "/src/by/it/zhivov/jd02_09/generated.xml";
        generateToXML();
        generateFromXML(generatedXML);


    }

    static void generateFromXML(String fileXML) {       //xml+xsd
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Persons.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            FileReader fileReader = new FileReader(fileXML);
            System.out.println("XML:" + fileXML + " Loaded\n");
            Persons persons = (Persons) unmarshaller.unmarshal(fileReader);
            System.out.println(persons + "\nend");
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void generateToXML() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Persons.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            Persons persons = new Persons();
            Ads ads = new Ads();
            Ad ad = new Ad("Полное дно", "BMW", "m3", "red", "sedan", 2006, "Comfort", 658, false, 7200);
            User user = new User("Zhivov", "Jerome", "A59915991", "23.12.1994", "jeromeastero@mail.ru", "+375330000000", false, ads);
            persons.getUser().add(user);
            ads.getAd().add(ad);
            ads = new Ads();
            ad = new Ad("Супер дно", "АУДИ", "m3", "fff", "sedan", 2006, "Comfort", 658, true, 7200);
            user = new User("FFFF", "JeroWDWme", "A59915991", "23.12.1994", "jeromeasawdawtero@mail.ru", "+375330000000", false, ads);
            persons.getUser().add(user);
            ads.getAd().add(ad);
            ads = new Ads();
            user = new User("wwww", "JeroWDWme", "A59915991", "23.12.1994", "jeromeasawdawtero@mail.ru", "+375330000000", false, ads);
            persons.getUser().add(user);
            Admin admin = new Admin("admin", "JJ2242", true);
            persons.getAdmin().add(admin);
            Guest guest = new Guest(false);
            persons.getGuest().add(guest);
            marshaller.marshal(persons, new FileOutputStream("src/by/it/zhivov/jd02_09/generated.xml"));
            System.out.println("Xml generated");
            marshaller.marshal(persons, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
