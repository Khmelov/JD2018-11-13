package by.it.zakharenko.jd02_09;

import by.it.zakharenko.jd02_09.beans.Clients;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskA {

    private static String filename = System.getProperty("user.dir") + "/src/by/it/zakharenko/jd02_09/clients+xsd.xml";

    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Clients.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Clients clients = (Clients) unmarshaller.unmarshal(new File(filename));
            System.out.println(clients);
            System.out.println();

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(clients, System.out);
            System.out.println();

            GsonBuilder gsonBuilder = new GsonBuilder().serializeNulls();
            Gson gson = gsonBuilder.serializeNulls().setPrettyPrinting().create();
            String jsonText = gson.toJson(clients);
            System.out.println(jsonText);
            System.out.println();

            Clients fromJson = gson.fromJson(jsonText, Clients.class);
            System.out.println(fromJson);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}