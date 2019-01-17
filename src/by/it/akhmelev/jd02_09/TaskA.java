package by.it.akhmelev.jd02_09;

import by.it.akhmelev.jd02_09.beans.Persons;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskA {
    private static String filename = System.getProperty("user.dir") +
            "/src/by/it/akhmelev/jd02_09/person+xsd.xml";

    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Persons.class);
            System.out.println("=========================== FROM XML ==============================");
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Persons persons = (Persons) unmarshaller.unmarshal(new File(filename));
            System.out.println(persons);

            Marshaller marshaller = context.createMarshaller();
            System.out.println("=========================== TO XML ==============================");
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(persons, System.out);

            System.out.println("=========================== TO JSON ==============================");
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.serializeNulls().setPrettyPrinting().create();
            String jsonText = gson.toJson(persons);
            System.out.println(jsonText);

            System.out.println("=========================== FROM JSON ==============================");
            Persons personsFromJson = gson.fromJson(jsonText, Persons.class);
            System.out.println(personsFromJson);
            if (personsFromJson.toString().equals(persons.toString()))
                System.out.println("Check OK");

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
