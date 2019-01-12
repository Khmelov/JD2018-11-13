package by.it._examples_.jd02_08;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
//
public class Ex03_DOM {
    public static void main(String[] args) {
        //runner
        //возьмем пример из предыдущего занятия
        String fileName = "src/by/it/_examples_/JD02_07/04+XSD.xml";
        //создадим фабрику и стандартный парсер
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder=factory.newDocumentBuilder();
            Document doc=builder.parse(fileName);
            Element el=doc.getDocumentElement();
            printDom("", el);
        } catch (Exception e) {
            System.out.print("Ошибка! " + e.toString());
        }
    }

    //Демо. Рекурсивный обход DOM-дерева.
    //На уровень C самостоятельно разберитесь, как переделать вывод в формате обычного XML
    //а также как и где извлечь значение и аттрибуты узла
    private static void printDom(String prefix, Node node) {
        String text=node.getNodeValue();
        if (text!=null) {
            System.out.println(prefix + text.trim());
        }
        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            printDom(prefix+node.getNodeName() + " > ", children.item(i));
        }
    }
}

