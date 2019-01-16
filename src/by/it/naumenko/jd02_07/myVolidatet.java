package by.it.naumenko.jd02_07;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class myVolidatet {
    public static void main(String[] args) {
        String nsUri = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(nsUri);
        String pathXml = Util.getPath("saleOfCakes+xsd.xml");
        String pathXsd = Util.getPath("saleOfCakes.xsd");
        try {
            Schema schema = factory.newSchema(new File(pathXsd));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(pathXml));
            System.out.println(pathXml + " не валиден");
        } catch (SAXException e) {
            System.err.println(pathXml + " не валиден");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

