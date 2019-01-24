package by.it.seroglazov.jd02_09;

import by.it.seroglazov.jd02_09.beans.ingredients.Ingredients;
import by.it.seroglazov.jd02_09.beans.recipes.Recipes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskB {

    private static Recipes recipes;

    public static void main(String[] args) {
        String parentDir = System.getProperty("user.dir") + "/src/by/it/seroglazov/jd02_09/";
        String recXMLFileName = parentDir + "manualXML/recipes+xsd.xml";
        readXml(recXMLFileName);
        if (recipes == null) System.out.println("Error. Can't parse file " + recXMLFileName);
        String json = getJson();
        //System.out.println(json);
        Recipes recipes2 = readJson(json);
        saveXml(recipes2, parentDir + "resultB.xml");
    }

    private static void readXml(String fileName) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Recipes.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            recipes = (Recipes) unmarshaller.unmarshal(new File(fileName));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static String getJson() {
        return new GsonBuilder().serializeNulls().setPrettyPrinting().create().toJson(recipes);
    }

    private static Recipes readJson(String json) {
        return new GsonBuilder().create().fromJson(json, Recipes.class);
    }

    private static void saveXml(Recipes bean, String fileName) {
        try {
            JAXBContext context = JAXBContext.newInstance(Recipes.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(bean, new File(fileName));
            marshaller.marshal(bean, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
