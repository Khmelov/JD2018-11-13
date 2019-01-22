package by.it.seroglazov.jd02_09;

import by.it.seroglazov.jd02_09.beans.ingredients.Ingredients;
import by.it.seroglazov.jd02_09.beans.recipes.Recipe;
import by.it.seroglazov.jd02_09.beans.recipes.Recipes;
import by.it.seroglazov.jd02_09.beans.users.Users;

import javax.xml.bind.*;
import java.io.File;

public class TaskA {
    public static void main(String[] args) {

        String parentDir = System.getProperty("user.dir") + "/src/by/it/seroglazov/jd02_09/";
        String ingXMLFileName = parentDir + "manualXML/ingredients+xsd.xml";
        String recXMLFileName = parentDir + "manualXML/recipes+xsd.xml";
        String usersXMLFileName = parentDir + "manualXML/users+xsd.xml";

        // Читаем из XML -> beans
        System.out.println("\n============ XML -> beans: Ingredients =================================");
        Ingredients ingredients = (Ingredients) Unmarsh(ingXMLFileName, Ingredients.class);
        System.out.println(ingredients);

        System.out.println("\n============ XML -> beans: Recipes ======================================");
        Recipes recipes = (Recipes) Unmarsh(recXMLFileName, Recipes.class);
        System.out.println(recipes);
        Unmarsh(recXMLFileName, Recipes.class);

        System.out.println("\n============ XML -> beans: Users ========================================");
        Users users = (Users) Unmarsh(usersXMLFileName, Users.class);
        System.out.println(users);
        Unmarsh(usersXMLFileName, Users.class);

        // From beans -> XML
        try {
            System.out.println("\n============ beans -> XML: Ingredients =============================");
            JAXBContext context = JAXBContext.newInstance(Ingredients.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(ingredients, new File(parentDir + "/generatedXML/ingredients.xml"));
            marshaller.marshal(ingredients, System.out);
            //
            System.out.println("\n============beans -> XML: Recipes ==================================");
            context = JAXBContext.newInstance(Recipes.class);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(recipes, new File(parentDir + "/generatedXML/recipes.xml"));
            marshaller.marshal(recipes, System.out);
            //
            System.out.println("\n============beans -> XML: Users =====================================");
            context = JAXBContext.newInstance(Users.class);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(users, new File(parentDir + "/generatedXML/users.xml"));
            marshaller.marshal(users, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }

    private static Object Unmarsh(String fileName, Class cl) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(cl);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return unmarshaller.unmarshal(new File(fileName));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return new Object();
    }


}
