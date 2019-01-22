package by.it.mnovikov.jd02_09;

import by.it.mnovikov.jd02_09.beans.Organizations;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TaskB {

    private static Organizations organizations;
    private static String input = System.getProperty("user.dir") + "/src/by/it/mnovikov/jd02_09/organizations.xml";
    private static String output = System.getProperty("user.dir") + "/src/by/it/mnovikov/jd02_09/" + "resultB.xml";


    public static void main(String[] args) {

        readXml(input);
        String json = getJson();
        Organizations organizationsJSON = readJson(json);
        saveXml(organizationsJSON, output);
    }

    private static void readXml(String filename) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Organizations.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            organizations = (Organizations) unmarshaller.unmarshal(new FileReader(filename));
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String getJson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.serializeNulls().setPrettyPrinting().create();
        return gson.toJson(organizations);
    }

    private static Organizations readJson(String json) {
        return new GsonBuilder().create().fromJson(json, Organizations.class);
    }

    private static void saveXml(Organizations bean, String fileName) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Organizations.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(bean, new File(fileName));
            marshaller.marshal(bean, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
