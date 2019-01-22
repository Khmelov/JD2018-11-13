/*
package by.it.markelov.jd02_09;

import by.it.markelov.jd02_09.schemetobeans.Clients;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TaskB {
   public static void readXml(File file) {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(Clients.class);
            System.out.println("Transformation from XML to BEAN");
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Clients clients = (Clients) unmarshaller.unmarshal(file);
            System.out.println(clients);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void getJson(Clients clients) {
        System.out.println("Transformation from BEAN to JSON");
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.serializeNulls().setPrettyPrinting().create();
        String jsonText = gson.toJson(clients);
        System.out.println(jsonText);
    }

   public static void readJson(String json) {
        System.out.println("Transformation from JSON to BEAN");
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.serializeNulls().setPrettyPrinting().create();
        Clients clients = gson.fromJson(json, Clients.class);
        System.out.println(clients);
    }

   public static void saveXml(File file) {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(Clients.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            System.out.println("Transformation from BEAN to XML");
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(Clients.class, new FileWriter(file));

        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File fileA=new File("D:\\Мои программы\\Java\\JD2018-11-13\\src\\by\\it\\markelov\\jd02_09\\clients.xml");
        File resultB=new File("D:\\Мои программы\\Java\\JD2018-11-13\\src\\by\\it\\markelov\\jd02_09\\resultB.xml");

        readXml(fileA);
        //getJson();
        readJson(resultB.toString());
        saveXml(resultB);
    }
}
*/
