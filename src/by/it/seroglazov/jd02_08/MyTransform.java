package by.it.seroglazov.jd02_08;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class MyTransform {
    //private final static String root="src/by/it/_examples_/jd02_08/";
    public static void main(String[] args) {
        String parentDir = System.getProperty("user.dir") + "/src/by/it/seroglazov/jd02_07/";
        String parentDir2 = System.getProperty("user.dir") + "/src/by/it/seroglazov/jd02_08/";

        String ingredientsXML = parentDir + "ingredients/ingredients.xml";
        String recipesXML = parentDir + "recipes/recipes.xml";
        String usersXML = parentDir + "users/users.xml";

        String ingredientsXSL = parentDir2 + "Ingredients.xsl";
        String recipesXSL = parentDir2 + "Recipes.xsl";
        String usersXSL = parentDir2 + "Users.xsl";

        String ingredientsHTML = parentDir2 + "HTML_out/Ingredients.html";
        String recipesHTML = parentDir2 + "HTML_out/Recipes.html";
        String usersHTML = parentDir2 + "HTML_out/Users.html";

        MyTrans(ingredientsXML, ingredientsXSL, ingredientsHTML);
        MyTrans(recipesXML, recipesXSL, recipesHTML);
        MyTrans(usersXML, usersXSL, usersHTML);
    }

    private static void MyTrans(String xmlFileName, String xslFileName, String outHTMLFileName) {
        if (!(new File(xslFileName).exists())) {
            System.err.println("Файл не найден: " + xslFileName);
            return;
        }
        if (!(new File(xmlFileName).exists())) {
            System.err.println("Файл не найден: " + xmlFileName);
            return;
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
            Transformer transformer = transformerFactory.newTransformer(new StreamSource(xslFileName));
            transformer.transform(new StreamSource(xmlFileName), new StreamResult(outHTMLFileName));
        } catch (TransformerConfigurationException e) {
            System.err.println("Transformer configuration exception: " + e.getMessage());
        } catch (TransformerException e) {
            System.err.println("Transformer exception: " + e.getMessage());
        }
        System.out.println(xmlFileName + " - transform complete");
    }
}
