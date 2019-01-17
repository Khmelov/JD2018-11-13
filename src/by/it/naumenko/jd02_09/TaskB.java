package by.it.naumenko.jd02_09;

import by.it.naumenko.jd02_09.beens.Cakes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskB {

    private static String fileName=System.getProperty("user.dir")+"/src/by/it/naumenko/jd02_09/cakes+xsd.xml";

    public static void main(String[] args) {

        Cakes cakes = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Cakes.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            cakes = (Cakes) unmarshaller.unmarshal(new File(fileName));
        } catch (JAXBException e) {
            e.printStackTrace();
        }


        System.out.println("==============================to JSON==============================");
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.serializeNulls().setPrettyPrinting().create();
        String jsonText = toJson(cakes, gson);


        System.out.println("=============================from JSON=============================");

        Cakes cakesFromJson = fromJson(gson, jsonText);
        if(cakes.toString().equals(cakesFromJson.toString()))
            System.out.println("ok");
        else
            System.out.println("error");


    }

    private static String toJson(Cakes cakes, Gson gson) {
        String jsonText = gson.toJson(cakes);
        System.out.println(jsonText);
        return jsonText;
    }

    private static Cakes fromJson(Gson gson, String jsonText) {
        Cakes cakesFromJson = gson.fromJson(jsonText, Cakes.class);
        System.out.println(cakesFromJson);
        return cakesFromJson;
    }
}
