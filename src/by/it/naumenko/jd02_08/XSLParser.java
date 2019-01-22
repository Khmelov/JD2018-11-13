package by.it.naumenko.jd02_08;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XSLParser {

    final static String root="src/by/it/naumenko";

    public static void main(String[] args) {
        String xmlFile=root+"jd02_07/saleOfCakes.xml";
        String htmlFile=root+"jd02_08/saleOfCakes.html";

        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer(new StreamSource(root + "jd02_08/saleOfCakes.xsl"));
            transformer.transform(new StreamSource(xmlFile),
                    new StreamResult(htmlFile));
            System.out.println("Transform " + xmlFile + "complite");
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }
}
