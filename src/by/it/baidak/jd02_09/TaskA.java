package by.it.baidak.jd02_09;

import by.it.baidak.jd02_09.generate.Users;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

public class TaskA {
    public static void main(String[] args) throws JAXBException, FileNotFoundException {

        JAXBContext jc = JAXBContext.newInstance(Users.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Users users = (Users) unmarshaller.unmarshal(new FileReader("src/by/it/baidak/jd02_07/users+xsd.xml"));

        Marshaller marshaller = jc.createMarshaller();
        marshaller.marshal(users, new FileOutputStream("src/by/it/baidak/jd02_09/fromJD07.xml"));
    }
}
