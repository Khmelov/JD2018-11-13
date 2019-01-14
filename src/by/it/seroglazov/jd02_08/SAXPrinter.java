package by.it.seroglazov.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SAXPrinter extends DefaultHandler {
    public static void main(String[] args) {
        String parentDir = System.getProperty("user.dir") + "/src/by/it/seroglazov/jd02_07/";
        String myIngredientsFile = parentDir + "ingredients/ingredients+xsd.xml";
        String myRecipesFile = parentDir + "recipes/recipes+xsd.xml";
        String myUsersFile = parentDir + "users/users+xsd.xml";
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            myParse(myIngredientsFile, saxParser);
            myParse(myRecipesFile, saxParser);
            myParse(myUsersFile, saxParser);
        } catch (SAXException e) {
            System.err.println("Error while getting XMLReader: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error while parsing XML: " + e.getMessage());
        } catch (ParserConfigurationException e) {
            System.err.println("Error with XML Parser: " + e.getMessage());
        }
    }

    private static SAXPrinter saxPrinter = new SAXPrinter();

    private static void myParse(String myFile, SAXParser parser) throws IOException, SAXException {
        System.out.println("Parsing " + myFile);
        parser.parse(myFile, saxPrinter);
        System.out.println("===============================================================================");
        System.out.println();
    }

    private String tab = "";
    private StringBuilder value = new StringBuilder();

    @Override
    public void startDocument() throws SAXException {
    }

    @Override
    public void endDocument() throws SAXException {
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.printf("%s<%s", tab, qName);
        int len = attributes.getLength();
        for (int i = 0; i < len; i++) {
            System.out.print(" " + attributes.getLocalName(i) + "=\"" +attributes.getValue(i) + "\"");
        }
        System.out.println(">");
        tab = tab.concat("\t");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (value.length() > 0) {
            System.out.print(tab);
            System.out.println(value.toString());
            value.setLength(0);
        }
        tab = tab.substring(1);
        System.out.printf("%s</%s>%n", tab, qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String str = new String(ch, start, length).trim();
        value.append(str);
    }
}
