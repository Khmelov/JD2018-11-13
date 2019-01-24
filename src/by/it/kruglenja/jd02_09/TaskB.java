package by.it.kruglenja.jd02_09;

import by.it.kruglenja.jd02_09.beans.Spareparts;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class TaskB {
    private static Spareparts spareparts;
    private static Spareparts sparepartsFromJson;

    private static void readXml() {
        try {
            FileReader reader = new FileReader("C:/Users/Tom/IdeaProjects/JD2018-11-13/src/by/it/kruglenja/jd02_09/spareparts+xsd.xml");
            JAXBContext context = JAXBContext.newInstance(Spareparts.class);
            Unmarshaller unMarsh = context.createUnmarshaller();
            spareparts = (Spareparts) unMarsh.unmarshal(reader);
//            System.out.println(spareparts);
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String getJson() {

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.serializeNulls().setPrettyPrinting().create();
        String ssd = gson.toJson(spareparts);
        System.out.println(ssd);
        try {
            FileWriter fw = new FileWriter("C:/Users/Tom/IdeaProjects/JD2018-11-13/src/by/it/kruglenja/jd02_09/spareparts.json");
            fw.write(ssd);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ssd;
    }

    private static void readJson(String json) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        sparepartsFromJson = gson.fromJson(getJson(), Spareparts.class);
        System.out.println("Matching equals " + sparepartsFromJson.toString().equals(spareparts.toString()));

    }

    private static void saveXml() {
        try {
            FileWriter fw = new FileWriter("C:/Users/Tom/IdeaProjects/JD2018-11-13/src/by/it/kruglenja/jd02_09/spareparts.xml");
            fw.write(sparepartsFromJson.toString());
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        readXml();
        readJson(getJson());
        saveXml();
    }
}
