package by.it.nickgrudnitsky.jd02_09;

import by.it.nickgrudnitsky.jd02_09.beans.Twitch;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TaskB {
    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        Twitch twitch = readXml();
        String json = getJson(twitch);
        Twitch twitch1 = readJson(json);
        saveXml(twitch1);

    }

    private static void saveXml(Twitch twitch) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Twitch.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(twitch, new File("src/by/it/nickgrudnitsky/jd02_09/resultB.xml"));
    }

    private static Twitch readJson(String json) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.serializeNulls().setPrettyPrinting().create();
        Twitch twitch = gson.fromJson(json, Twitch.class);
        System.out.println(twitch);
        return twitch;
    }

    private static String getJson(Twitch twitch) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.serializeNulls().setPrettyPrinting().create();
        String toJson = gson.toJson(twitch);
        System.out.println(toJson);
        return toJson;
    }

    private static Twitch readXml() throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(Twitch.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        FileReader fileReader = new FileReader("src/by/it/nickgrudnitsky/jd02_09/resultA.xml");
        System.out.println("XML-файл прочитан:");
        Twitch twitch = (Twitch) unmarshaller.unmarshal(fileReader);
        System.out.println(twitch);
        return twitch;
    }
}
