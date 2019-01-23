package by.it.vchernetski.jd02_09.TaskA;


import by.it.vchernetski.jd02_09.beans.Drivers;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskA {
    private static String xmlFile = System.getProperty("user.dir")+"/src/by/it/vchernetski/jd02_09/Drivers+xsd.xml";
    private static String finXML = System.getProperty("user.dir")+"/src/by/it/vchernetski/jd02_09/TaskA/NewXMLDrivers.xml";
    private static JAXBContext jaxbContext;
    private static Drivers drivers;
    public static void main(String[] args) {

// xml to bean
        try{
            jaxbContext = JAXBContext.newInstance(Drivers.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            drivers = (Drivers) unmarshaller.unmarshal(new File(xmlFile));
            System.out.println(drivers);
        }
        catch (JAXBException e){
            e.printStackTrace();
        }
// bean to xml
        try{
            jaxbContext=JAXBContext.newInstance(Drivers.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(drivers,new File(finXML));
        }
        catch (JAXBException e){
            e.printStackTrace();
        }
    }
}
