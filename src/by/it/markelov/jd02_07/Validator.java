package by.it.markelov.jd02_07;

import org.xml.sax.SAXException;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

public class Validator {
    public static void main(String[] args) {
        String schemaNsUri = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(schemaNsUri);
        String xsd=Path.pathOfThisDirectory(Validator.class)+File.separator+"clients.xsd";
        String xml=Path.pathOfThisDirectory(Validator.class)+File.separator+"clients+xsd.xml";

        try {
            Schema schema = factory.newSchema(new File(xsd));
            javax.xml.validation.Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xml)));
            System.out.println(xml+"\nvalid");
        } catch (SAXException e) {
            System.err.println(xml+" non valid");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
