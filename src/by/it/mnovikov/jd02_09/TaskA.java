package by.it.mnovikov.jd02_09;

import by.it.mnovikov.jd02_09.beans.Organizations;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by user on 15.01.2019.
 */
public class TaskA {

    private static String fileName = System.getProperty("user.dir")+"src/by/it/mnovikov/jd02_09/organization+xsd.xml";

    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Organizations.class);
            System.out.println("=======================FROM XML=======================");
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Organizations organizations = (Organizations) unmarshaller.unmarshal(new File(fileName));
            System.out.println(organizations);

            Marshaller marshaller = jaxbContext.createMarshaller();
            System.out.println("=======================TO XML=======================");
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(organizations, System.out);

            System.out.println("=======================TO JSON=======================");
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.serializeNulls().setPrettyPrinting().create();
            String jsonText = gson.toJson(organizations);
            System.out.println(jsonText);

            System.out.println("=======================TO JSON=======================");

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
