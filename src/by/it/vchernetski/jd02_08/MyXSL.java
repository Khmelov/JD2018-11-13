package by.it.vchernetski.jd02_08;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class MyXSL {
    final static String root= "src/by/it/vchernetski/jd02_08/";

    public static void main(String[] args) {
        String fileName = root+"Drivers.xml";
        String fileHTML = root+"Drivers.html";
        try{
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(root+"Drivers.xsl"));
            transformer.transform(new StreamSource(fileName),new StreamResult(fileHTML));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
