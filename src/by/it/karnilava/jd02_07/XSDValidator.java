package by.it.karnilava.jd02_07;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XSDValidator {
    public static void main(String[] args) {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String src = System.getProperty("user.dir") + "/src/by/it/karnilava/";
        String filename = src + "jd02_07\\bankClients.xsd.xml";
        String schemaPath = src + "jd02_07\\bankClients.xsd";
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaPath);
        try {
            Schema scema = factory.newSchema(schemaLocation);
            Validator validator = scema.newValidator();
            Source source = new StreamSource(filename);
            validator.validate(source);
            System.out.println(filename+ " is absolutely valid");

        }
        catch (SAXException e){
            System.err.println("Validation of "+filename+" is failed"+e.getMessage());
        }
        catch (IOException e){
            System.err.println(filename + " is invalid. "+e.getMessage());
        }


    }
}
