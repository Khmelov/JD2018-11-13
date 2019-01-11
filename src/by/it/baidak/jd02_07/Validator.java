package by.it.baidak.jd02_07;

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
        String xsd=System.getProperty("user.dir")+"/src/by/it/baidak/jd02_07/users.xsd";
        String xml=System.getProperty("user.dir")+"/src/by/it/baidak/jd02_07/users+xsd.xml";
        try {
            SchemaFactory factory = SchemaFactory.newInstance(schemaNsUri);
            Schema schema = factory.newSchema(new File(xsd));
            javax.xml.validation.Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xml));
            System.out.println(xml+" valid");
        } catch (SAXException e) {
            System.err.println(xml+" non valid");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
