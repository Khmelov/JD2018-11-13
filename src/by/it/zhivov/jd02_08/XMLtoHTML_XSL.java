package by.it.zhivov.jd02_08;


import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XMLtoHTML_XSL {
    private final static String root = "src/by/it/zhivov/jd02_07/";

    static void xmlToHtml(String fileXML, String fileHTML, String fileXSL) {
        StreamSource fileXml = new StreamSource(fileXML);
        StreamResult fileHtml = new StreamResult(fileHTML);
        StreamSource fileXsl = new StreamSource(fileXSL);
        System.out.println("\nStart XMLtoHTML_xpath transformation\n"+"xml:"+fileXML+"\n"+"xsl:"+fileXSL+"\n");
        try {
            TransformerFactory worker = TransformerFactory.newInstance();
            Transformer transformer = worker.newTransformer(fileXsl);
            transformer.transform(fileXml, fileHtml);
            System.out.println("\nTransformation complete\n"+"html:"+fileHTML);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}

