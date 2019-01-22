package by.it.skarpovich.jd02_09;

import by.it.skarpovich.jd02_09.beans.Buyers;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class TaskA {
    private static String fileName = System.getProperty("user.dir") + "/src/by/it/skarpovich/jd02_09/buyers+xsd.xml";
    private static String toXML = System.getProperty("user.dir") + "/src/by/it/skarpovich/jd02_09/buyers.xml";

    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Buyers.class);
            System.out.println("====================FROM XML====================");
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Buyers buyers = (Buyers) unmarshaller.unmarshal(new File(fileName));
            System.out.println(buyers);

            Marshaller marshaller = jaxbContext.createMarshaller();
            System.out.println("====================TO XML======================");
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(buyers, System.out);
            marshaller.marshal(buyers, new File(toXML) );


            GsonBuilder gsonBuilder = new GsonBuilder();
            System.out.println("====================TO JSON=====================");
            Gson gson = gsonBuilder.serializeNulls().setPrettyPrinting().create();
            String jsonText = gson.toJson(buyers);
            System.out.println(jsonText);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
