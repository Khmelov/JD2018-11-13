package by.it.mnovikov.jd02_08;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class DOM_run {

    private static String xml = System.getProperty("user.dir") + "/src/by/it/mnovikov/jd02_08/organization+xsd.xml";

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
        int type = node.getNodeType();
        if (type == Node.ELEMENT_NODE) {
            System.out.print(prefix + "<" + node.getNodeName().trim());
            if (node.hasAttributes()) {
                NamedNodeMap nodeAttributes = node.getAttributes();
                for (int i = 0; i < nodeAttributes.getLength(); i++) {
                    Node attribite = nodeAttributes.item(i);
                    System.out.print(" " + attribite.getNodeName() + "=" + attribite.getNodeValue());
                }
            }
            System.out.println(">");
        }
        String text = node.getNodeValue();
        String prefix_mod = prefix.concat("\t");
        if (text != null) {
            text = text.trim();
            if (text.length() > 0)
            System.out.println(prefix + text);
        }
        NodeList child = node.getChildNodes();
        for (int i = 0; i < child.getLength(); i++) {
            printDom(prefix_mod, child.item(i));
        }
        if (type == Node.ELEMENT_NODE) {
            System.out.println(prefix + "</" + node.getNodeName() + ">");
        }
    }
}
