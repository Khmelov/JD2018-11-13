package by.it.kruglenja.jd02_07.spareparts;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class xsdValidator {
    public static void main(String[] args) {
        String schemNsUri = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(schemNsUri);
        String xsd = System.getProperty("user.dir") + "\\src\\by\\it\\kruglenja\\jd02_07\\spareparts\\spareparts.xsd";
        String xml = System.getProperty("user.dir") + "\\src\\by\\it\\kruglenja\\jd02_07\\spareparts\\spareparts+xsd.xml";
        Schema schema;

        {
            try {

                schema = factory.newSchema(new File(xsd));
                Validator validator = schema.newValidator();
                validator.validate(new StreamSource(xml));
                System.out.println(xml + " valit");
            } catch (SAXException e) {
                e.printStackTrace();
                System.out.println("Ne valit");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
