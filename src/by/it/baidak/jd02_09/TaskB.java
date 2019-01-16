package by.it.baidak.jd02_09;

import by.it.baidak.jd02_09.generate.Users;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class TaskB {

    private static Users users;
    private static File file = new File("src/by/it/baidak/jd02_09/fromJD07.xml");
    private static Gson json = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

    static void readXml(File file) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(Users.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        TaskB.users = (Users) unmarshaller.unmarshal(file);
    }

    static String getJSON(){
        return TaskB.json.toJson(TaskB.users);
    }

    static void readJSON(String json){
        TaskB.users = TaskB.json.fromJson(json, Users.class);
    }

    static void saveXml() throws JAXBException, FileNotFoundException {
        JAXBContext jc = JAXBContext.newInstance(Users.class);
        Marshaller marshaller = jc.createMarshaller();
        marshaller.marshal(TaskB.users, new FileOutputStream("src/by/it/baidak/jd02_09/fromGSON.xml"));
    }

    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        readXml(file);
        System.out.println(getJSON());
        readJSON(getJSON());
        saveXml();
    }
}
