package by.it.mnovikov.jd02_08;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class DOM_run {

    private static String xml = System.getProperty("user.dir")+ "/src/by/it/mnovikov/jd02_08/organization.xml";

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xml);
            Element element = document.getDocumentElement();
            printDom("", element);
        } catch (Exception e) {
            System.out.println("Ошибка!" + e.toString());
        }
    }

    private static void printDom(String prefix, Node node) {
        String text = node.getNodeValue();

        if (text!=null && !text.isEmpty()) {
            System.out.println(prefix + text.trim());
        }
        NodeList child = node.getChildNodes();
        for (int i = 0; i < child.getLength(); i++) {
            printDom(node.getNodeName() + ">" + child, child.item(i));
        }
    }
}
