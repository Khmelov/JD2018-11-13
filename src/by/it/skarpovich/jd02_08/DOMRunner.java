package by.it.skarpovich.jd02_08;

import by.it.skarpovich.jd02_07.Util;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
// UNCL

public class DOMRunner {

    public static void main(String[] args) {

        String xml = Util.getPath() + "buyers.xml";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xml);
            Element el = doc.getDocumentElement();
            printDom("", el);
        } catch (Exception e) {
            System.out.print("Ошибка! " + e.toString());
        }
    }
    private static void printDom(String prefix, Node node) {
        StringBuilder sbuilder = new StringBuilder();
        String tab = null;

        String text = node.getNodeValue();
        if (text != null && !text.isEmpty()) {
            //System.out.println(prefix + " value = \"" + text + "\"");
            System.out.print("<" + prefix + ">" + text);
        }

 //      NamedNodeMap attributes = node.getAttributes();
 //     if (attributes != null) {
//            for (int i = 0; i < attributes.getLength(); i++) {
//                Node attr = attributes.item(i);
//                String name = attr.getNodeName();
//                String value = attr.getTextContent();
//                sbuilder.append(" ").append(name).append("=\"").append(value).append("\"");
//            }
           // System.out.println("<" + node.getNodeName() + sbuilder + ">");
            //tab ="\t" + tab;    // Добавляем табуляцию
  //    }

        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            printDom(node.getNodeName(), children.item(i));
        }
    }
}
