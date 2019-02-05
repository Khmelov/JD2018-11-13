package by.it.zakharenko.jd02_09;

import by.it.zakharenko.jd02_09.beans.Clients;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskB {

    private static String fileName=System.getProperty("user.dir")+"/src/by/it/zakharenko/jd02_09/clients+xsd.xml";

    public static void main(String[] args) {

        Clients clients = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Clients.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            clients = (Clients) unmarshaller.unmarshal(new File(fileName));
        } catch (JAXBException e) {
            e.printStackTrace();
        }


        System.out.println("=========================== TO JSON ==============================");
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.serializeNulls().setPrettyPrinting().create();
        String jsonText = gson.toJson(clients);
        System.out.println(jsonText);


        System.out.println("=========================== FROM JSON ==============================");
        Clients personsFromJson = gson.fromJson(jsonText, Clients.class);
        System.out.println(personsFromJson);
        if (personsFromJson.toString().equals(clients.toString()))
            System.out.println("Check OK");

    }
}

