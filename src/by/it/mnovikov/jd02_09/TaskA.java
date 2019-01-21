package by.it.mnovikov.jd02_09;

import by.it.mnovikov.jd02_09.beans.Organizations;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by user on 15.01.2019.
 */
public class TaskA {

    private static String input = System.getProperty("user.dir")+"/src/by/it/mnovikov/jd02_09/organization+xsd.xml";
    private static String output = System.getProperty("user.dir")+"/src/by/it/mnovikov/jd02_09/organizations.xml";

    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Organizations.class);
            System.out.println("=======================FROM XML=======================");
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            FileReader reader = new FileReader(input);
            System.out.println("XML-file read:");
            Organizations organization = (Organizations) unmarshaller.unmarshal(reader);
            System.out.println(organization);

            Marshaller marshaller = jaxbContext.createMarshaller();
            System.out.println("=======================TO XML=======================");
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(organization, new File(output));
            marshaller.marshal(organization, System.out);

        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}


