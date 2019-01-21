package by.it.naumenko.jd02_09;

import by.it.naumenko.jd02_09.beens.Cakes;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskA {

    private final static String fileName=System.getProperty("user.dir")+"/src/by/it/naumenko/jd02_09/cakes+xsd.xml";
    private final static String newfileName=System.getProperty("user.dir")+"/src/by/it/naumenko/jd02_09/cakesMarsh+xsd.xml";
    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Cakes.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Cakes cakes = (Cakes) unmarshaller.unmarshal(new File(fileName));
            System.out.println(cakes);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(cakes,new File(newfileName));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
