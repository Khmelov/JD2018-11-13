package by.it.mnovikov.jd02_08;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class Converter {
    public static void main(String[] args) {
        String root = System.getProperty("user.dir")+"/src/by/it/mnovikov/jd02_08/";
        String xmlOrganization = root + "organization.xml";
        String xslOrganization = root + "organization.xsl";
        String htmlOrganization = root + "organization.html";


        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer(new StreamSource(xslOrganization));
            transformer.transform(new StreamSource(xmlOrganization), new StreamResult(htmlOrganization));
            System.out.println("Transform " + xmlOrganization + " complete");
        } catch (TransformerException e) {
            System.err.println("Impossible transform file " + xmlOrganization + " : " + e);
        }
    }
}
