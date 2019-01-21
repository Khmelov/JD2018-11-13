package by.it.kruglenja.jd02_09;

import by.it.kruglenja.jd02_09.beans.Spareparts;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class TaskA {
    static String fileName = System.getProperty("user.dir") + "/src/by/it/kruglenja/jd02_09/spareparts+xsd.xml";

    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Spareparts.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Object spareparts = unmarshaller.unmarshal(new File(fileName));
            System.out.println(spareparts);

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(spareparts, System.out);
            OutputStream os  = new FileOutputStream("C:/Users/Tom/IdeaProjects/JD2018-11-13/src/by/it/kruglenja/jd02_09/spareparts+xsd.xml");
            marshaller.marshal(spareparts, os);
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
