package by.it.markelov.jd02_09;

import by.it.markelov.jd02_09.schemetobeans.Clients;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TaskA {
    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext=JAXBContext.newInstance(Clients.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            FileReader fileReader=new FileReader("D:\\JD2018-11-13\\src\\by\\it\\markelov\\jd02_07\\clients.xml");
            Clients clients = (Clients) unmarshaller.unmarshal(fileReader);
            System.out.println(clients);

        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
