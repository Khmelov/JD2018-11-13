package by.it.seroglazov.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class SAXPrinter extends DefaultHandler {
    public static void main(String[] args) {
        SAXPrinter saxPrinter = new SAXPrinter();
        String str = "new" + 4 + 5 + 4.5+ 17+ "444"+34 + " " + 34.4545;
        System.out.println(str);
        String parentDir = System.getProperty("user.dir") + "/src/by/it/seroglazov/jd02_07/";
        String myIngredientsFile = parentDir + "ingredients/ingredients+xsd.xml";
        String myRecipesFile = parentDir + "recipes/recipes+xsd.xml";
        String myUsersFile = parentDir + "users/users+xsd.xml";
        try {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(saxPrinter);
            myParse(myIngredientsFile, xmlReader);
            myParse(myRecipesFile, xmlReader);
            myParse(myUsersFile, xmlReader);
        } catch (SAXException e) {
            System.err.println("Error while getting XMLReadre: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error while parsing XML: " + e.getMessage());
        }
    }

    private static void myParse(String myFile, XMLReader reader) throws IOException, SAXException {
        System.out.println("Parsing " + myFile);
        reader.parse(myFile);
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
            System.out.printf(" %s", attributes.getValue(i));
        }

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
