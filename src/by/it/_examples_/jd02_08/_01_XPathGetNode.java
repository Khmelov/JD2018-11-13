package by.it._examples_.jd02_08;

//прямой доступ к узлам через XPath

import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

//прямой доступ к узлам через XPath
public class _01_XPathGetNode {

    private static InputSource inputSource = new InputSource("src/by/it/_examples_/jd02_08/xpath.xml");
    private static XPath xpath = XPathFactory.newInstance().newXPath();

    private static String getText(String expression) throws XPathExpressionException {
        Node node = (Node) xpath.evaluate(expression, inputSource, XPathConstants.NODE);
        return node.getTextContent();
    }

    public static void main(String[] args) throws XPathExpressionException {
        String expression = "/students/student[@login='zPav16']/name";
        System.out.println(getText(expression));
        expression = "/students/student[@login='zPav16']/address";
        System.out.println(getText(expression));
    }
}



