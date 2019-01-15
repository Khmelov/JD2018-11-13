package by.it.skarpovich.jd02_07;

import org.xml.sax.SAXException;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XMLValidator {
    
    public static void main(String[] args) {
        String schemaNsUri = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(schemaNsUri);
        String xsd=Util.getPath()+"buyers.xsd";
        String xml=Util.getPath()+"buyers+xsd.xml";
      //String xsd=System.getProperty("user.dir")+"/src/by/it/skarpovich/jd02_07/buyers.xsd";
      //String xml=System.getProperty("user.dir")+"/src/by/it/skarpovich/jd02_07/buyers+xsd.xml";
        try {
            Schema schema = factory.newSchema(new File(xsd));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xml));
            System.out.println(xml+" is valid");
        } catch (SAXException e) {
            System.err.println(xml+" is invalid");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
