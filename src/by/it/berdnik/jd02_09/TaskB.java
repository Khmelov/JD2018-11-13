package by.it.berdnik.jd02_09;

import by.it.berdnik.jd02_09.beans.Persons;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskB {
    private static String fileName = System.getProperty("user.dir") + "/src/by/it/berdnik/jd02_09/persons.xml";
    private static String toXML = System.getProperty("user.dir") + "/src/by/it/berdnik/jd02_09/resultB.xml";
    private static JAXBContext jaxbContext;
    private static GsonBuilder gsonBuilder;
    private static Persons persons;

    public static void main(String[] args) {
        try {
            readXml();
            getJson();
            readJson(getJson());
            saveXml();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static void readXml() throws JAXBException {
        System.out.println("==================== FROM XML ====================");
        jaxbContext = JAXBContext.newInstance(Persons.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        persons = (Persons) unmarshaller.unmarshal(new File(fileName));
        System.out.println(persons);

    }

    private static String getJson() {
        System.out.println("==================== FROM BEAN TO JSON =====================");
        gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.serializeNulls().setPrettyPrinting().create();
        String jsonText = gson.toJson(persons);
        System.out.println(jsonText);
        return jsonText;
    }

    private static Persons readJson(String Json) {
        System.out.println("==================== FROM JSON TO BEAN =====================");
        gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.serializeNulls().setPrettyPrinting().create();
        Persons personsFromJson = gson.fromJson(Json, Persons.class);
        return personsFromJson;
    }

    private static void saveXml() throws JAXBException {
        System.out.println("==================== TO XML ======================");
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(persons, System.out);
        marshaller.marshal(persons, new File(toXML));
    }
}
