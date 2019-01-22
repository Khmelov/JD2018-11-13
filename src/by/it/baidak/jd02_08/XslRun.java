package by.it.baidak.jd02_08;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XslRun {

    private static String root = "src/by/it/baidak/jd02_08/";

    public static void main(String[] args) throws TransformerException {

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer(new StreamSource(root+"htmlTable.xsl"));
        transformer.transform(new StreamSource(root+"users.xml"), new StreamResult(root+"users.html"));
    }
}
