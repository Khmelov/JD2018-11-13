package by.it.markelov.jd02_08;

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

public class MyDOMParser {
    private static void stepThrough(Node start) {
        if (start.getNodeType() == Node.ELEMENT_NODE) {
            System.out.println("<" + start.getNodeName() + ">");
        } else System.out.println(start.getTextContent().trim());
        for (Node child = start.getFirstChild();
             child != null;
             child = child.getNextSibling()) {
            stepThrough(child);
        }
    }

    public static void main(String[] args) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        Document treeOfDocument = null;
        File fileToParse = new File(Path.pathOfThisDirectory(MyTransformer.class) + File.separator + "clients.xml");

        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            treeOfDocument = documentBuilder.parse(fileToParse);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        Element root = treeOfDocument.getDocumentElement();
        stepThrough(root);
    }
}

