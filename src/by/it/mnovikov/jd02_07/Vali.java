package by.it.mnovikov.jd02_07;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class Vali {
    public static void main(String[] args) {
        String schemaNsUri = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory schemaFactory = SchemaFactory.newInstance(schemaNsUri);
        String xsd = System.getProperty("user.dir") + "/src/by/it/mnovikov/jd02_07/organization.xsd";
        String xml = System.getProperty("user.dir") + "/src/by/it/mnovikov/jd02_07/organization+xsd.xml";

        try {
            Schema schema = schemaFactory.newSchema(new File(xsd));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xml));
            System.out.println(xml + " - valid");
        } catch (SAXException e) {
            System.err.println(xml + " - non valid");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
