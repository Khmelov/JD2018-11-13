/*
package by.it.markelov.jd02_09;

import by.it.markelov.jd02_09.schemetobeans.Clients;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskA {
    private static File fileXML=new File("D:\\Мои программы\\Java\\JD2018-11-13\\src\\by\\it\\markelov\\jd02_07\\clients.xml");

    public static void main(String[] args) {

        try {
            JAXBContext jaxbContext=JAXBContext.newInstance(Clients.class);
            System.out.println("Transformation from XML to BEAN");
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Clients clients = (Clients) unmarshaller.unmarshal(fileXML);
            System.out.println(clients);

            Marshaller marshaller = jaxbContext.createMarshaller();
            System.out.println("Transformation from BEAN to XML");
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(clients, System.out);

            System.out.println("Transformation from BEAN to JSON");
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.serializeNulls().setPrettyPrinting().create();
            String jsonText = gson.toJson(clients);
            System.out.println(jsonText);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
*/
