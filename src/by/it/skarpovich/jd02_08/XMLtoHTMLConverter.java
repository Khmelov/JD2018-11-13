package by.it.skarpovich.jd02_08;

import by.it.skarpovich.jd02_07.Util;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XMLtoHTMLConverter {
    // private final static String root="src/by/it/skarpovich/jd02_08/";
    public static void main(String[ ] args) {
        String fileXML= Util.getPath()+"buyers.xml";     // XML (from)
        String fileXSL= Util.getPath()+"xpath.xsl";     // XSL (stylesheet)
        String fileHTML= Util.getPath()+"buyers.html";   // HTML (result)

        //String fileName=root+"xpath.xml";
        //String fileHTML=root+"xpath.html";

        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            // установка используемого XSL-преобразования
            Transformer transformer = tf.newTransformer(new StreamSource(fileXSL));
            // установка исходного XML-документа и конечного XML-файла
            transformer.transform(new StreamSource(fileXML),
                    new StreamResult(fileHTML));
            System.out.println("Conversion " + fileXML + " completed!");
        } catch(TransformerException e) {
            System.err.println("Impossible to convert file " + fileXML + " : " + e);
        }
}
}
