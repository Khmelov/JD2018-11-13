package by.it.seroglazov.jd02_09;

import by.it.seroglazov.jd02_09.generate.recipes.Ingredient;
import by.it.seroglazov.jd02_09.generate.recipes.Ingredients;
import org.w3c.dom.Node;

import javax.xml.bind.*;
import java.io.File;

public class TaskA {
    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Ingredients.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Ingredients ingredients = (Ingredients) unmarshaller.unmarshal(new File("src/by/it/seroglazov/jd02_09/manualXML/ingredients+xsd.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
