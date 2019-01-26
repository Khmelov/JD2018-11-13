package by.it.lobkova.jd02_09;

import by.it.lobkova.jd02_09.beans.Persons;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskA_B {

    private static String filename = System.getProperty("user.dir") + "/src/by/it/lobkova/jd02_09/person+xsd.xml";

    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Persons.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Persons persons = (Persons) unmarshaller.unmarshal(new File(filename));
            System.out.println(persons);
            System.out.println();

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(persons, System.out);
            System.out.println();

            GsonBuilder gsonBuilder = new GsonBuilder().serializeNulls();
            Gson gson = gsonBuilder.serializeNulls().setPrettyPrinting().create();
            String jsonText = gson.toJson(persons);
            System.out.println(jsonText);
            System.out.println();

            Persons fromJson = gson.fromJson(jsonText, Persons.class);
            System.out.println(fromJson);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
