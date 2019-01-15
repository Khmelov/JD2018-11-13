package by.it._examples_.jd02_08;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class _02_And_XSL_04 {

    //использование XPath в преобразованиях XSL
    private final static String root="src/by/it/_examples_/jd02_08/";
    public static void main(String[ ] args) {
        String fileName=root+"xpath.xml";
        String fileHTML=root+"xpath.html";

        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            // установка используемого XSL-преобразования
            Transformer transformer = tf.newTransformer(new StreamSource(root+"xpath.xsl"));
            // установка исходного XML-документа и конечного XML-файла
            transformer.transform(new StreamSource(fileName),
                    new StreamResult(fileHTML));
            System.out.println("Transform " + fileName + " complete");
        } catch(TransformerException e) {
            System.err.println("Impossible transform file " + fileName + " : " + e);
        }
}
}
