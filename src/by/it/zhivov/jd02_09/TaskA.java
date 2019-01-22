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
            Ad ad = new Ad("Bmwx5", "Nice car", "BMW", "m3", "red", "sedan", 2006, "Comfort", 658, false, 7200);
            User user = new User("Anton Zhivov", "Jerome94", "A59915991", "23.12.1994", "jerome@astero.com", "+375333830046", ads);
            persons.getUser().add(user);
            ads.getAd().add(ad);
            ad = new Ad("apeer", "Super 8", "Volvo", "XC90", "red", "sedan", 2006, "Comfort", 658, false, 7200);
            ads.getAd().add(ad);
            ads = new Ads();
            user = new User("Pepper", "guzli", "awdawwa22", "23.12.2016", "dwadaw@dwaWD.ru", "+375333830046", ads);
            ad = new Ad("Batmobile", "uragan", "VAZ", "2101", "pupule", "sedan", 1985, "Comfort", 580000, true, 23000);
            persons.getUser().add(user);
            ads.getAd().add(ad);
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
