package by.it.berdnik.jd02_08;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XMLinHTML {
    private final static String root="src/by/it/berdnik/jd02_08/";
    public static void main(String[] args) {
        String fileName=root+"person.xml";
        String fileHTML=root+"person.html";
        try{
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(root+"person.xsl"));
            transformer.transform(new StreamSource(fileName),new StreamResult(fileHTML));
            System.out.println("Transform " + fileName + " complete");
        }
        catch(TransformerException e) {
            System.err.println("Impossible transform file " + fileName + " : " + e);
        }
    }
}
