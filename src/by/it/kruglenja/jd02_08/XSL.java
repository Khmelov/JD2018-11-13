package by.it.kruglenja.jd02_08;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XSL {
    private static String cat = System.getProperty("user.dir") + "/src/by/it/kruglenja/jd02_07/spareparts/";

    public static void main(String[] args) {
        String xmlFile = cat + "spareparts.xml";
        String htmlFile = cat + "spareparts.html";
        String xpathFile = System.getProperty("user.dir") + "/src/by/it/kruglenja/jd02_08/xpath.xsl";

        {
            try {
                TransformerFactory factory = TransformerFactory.newInstance();
                Transformer transformer = factory.newTransformer(new StreamSource( xpathFile));
                transformer.transform(new StreamSource(xmlFile), new StreamResult(htmlFile));
                System.out.println("Finish");
            } catch (TransformerException e) {
                e.printStackTrace();
            }
        }
    }
}
