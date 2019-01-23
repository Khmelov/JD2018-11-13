package by.it.vchernetski.jd02_09.TaskB;

import by.it.vchernetski.jd02_09.beans.Driver;
import by.it.vchernetski.jd02_09.beans.Drivers;
import com.google.gson.GsonBuilder;

import javax.xml.bind.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TaskB {
    private static Drivers drivers;
    private static String xmlFile = System.getProperty("user.dir")+"/src/by/it/vchernetski/jd02_09/TaskA/NewXMLDrivers.xml";
    private static String saveFile = System.getProperty("user.dir")+"/src/by/it/vchernetski/jd02_09/TaskB/resultB.xml";
    private static void readXML(String xml){
        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(Drivers.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            drivers = (Drivers) unmarshaller.unmarshal(new File(xml));
        }
        catch (JAXBException e){
            e.printStackTrace();
        }
    }
    private static String getJson(){
        return new GsonBuilder().serializeNulls().setPrettyPrinting().create().toJson(drivers);
    }
    private static Drivers readJson(String json){
        return new GsonBuilder().create().fromJson(json,Drivers.class);
    }
    private static void saveXml(Drivers dr, String finXML){
        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(Drivers.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(dr,new File(finXML));
        }
        catch (JAXBException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Path path  = Paths.get(xmlFile);
        if(!Files.exists(path)) System.out.println("Run TaskA to creat needed file, thank you");
        else {
            readXML(xmlFile);
            String js = getJson();
            Drivers dr = readJson(js);
            saveXml(dr, saveFile);
            System.out.println("It's ok");
        }
    }
}
