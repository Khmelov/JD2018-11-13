package by.it.naumenko.jd02_08;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DomRunner {
    static String xml = System.getProperty("user.dir") + "/src/by/it/naumenko/jd02_07/cakes/cakes+xsd.xml";

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        Document document = null;
        try {
            builder = factory.newDocumentBuilder();
            File file = new File(xml);
            document=builder.parse(file);
            Element element=document.getDocumentElement();
            printDom("<",element);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

    }

    static void printDom(String prefix, Node node){
        String text = node.getNodeValue();
        if (text!=null){
            System.out.println(prefix + text.trim());
        }
        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            printDom(prefix+node.getNodeName()+">",children.item(i));
        }
    }

}
