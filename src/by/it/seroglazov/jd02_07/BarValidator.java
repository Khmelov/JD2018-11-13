package by.it.seroglazov.jd02_07;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class BarValidator {
    public static void main(String[] args) {
        String myDir = System.getProperty("user.dir");

        File xsd = new File(myDir + "/src/by/it/seroglazov/jd02_07/ingredients/ingredients.xsd");
        File xml = new File(myDir + "/src/by/it/seroglazov/jd02_07/ingredients/ingredients+xsd.xml");
        MyValidator(xsd, xml);

        xsd = new File(myDir + "/src/by/it/seroglazov/jd02_07/recipes/recipes.xsd");
        xml = new File(myDir + "/src/by/it/seroglazov/jd02_07/recipes/recipes+xsd.xml");
        MyValidator(xsd, xml);

        xsd = new File(myDir + "/src/by/it/seroglazov/jd02_07/users/users.xsd");
        xml = new File(myDir + "/src/by/it/seroglazov/jd02_07/users/users+xsd.xml");
        MyValidator(xsd, xml);

    }

    private static void MyValidator(File xsd, File xml) {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Schema schema = schemaFactory.newSchema(xsd);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xml));
            System.out.println("File "+ xml.getName() + " is valid!");
        } catch (SAXException e) {
            System.err.println("File " + xml.getName() + " is not valid");
        } catch (IOException e) {
            System.err.println("Error reading file: " + xml.getName() + " with message: " + e.getMessage());
        }
    }
}
