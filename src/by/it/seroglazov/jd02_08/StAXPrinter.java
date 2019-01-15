package by.it.seroglazov.jd02_08;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

public class StAXPrinter {
    public static void main(String[] args) {
        //StAXPrinter instance = new StAXPrinter();
        String parentDir = System.getProperty("user.dir") + "/src/by/it/seroglazov/jd02_07/";
        String myIngredientsFile = parentDir + "ingredients/ingredients+xsd.xml";
        String myRecipesFile = parentDir + "recipes/recipes+xsd.xml";
        String myUsersFile = parentDir + "users/users+xsd.xml";
        printFile(myIngredientsFile);
        printFile(myRecipesFile);
        printFile(myUsersFile);
    }

    private static String tab = "";
    private static StringBuilder value = new StringBuilder();

    private static void printFile(String fileName) {
        System.out.println("Reading file " + new File(fileName).getAbsolutePath());
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));
            while (reader.hasNext()) {
                XMLEvent xmlEvent = reader.nextEvent();
                if (xmlEvent.isStartElement()) startElement(xmlEvent);
                else if (xmlEvent.isEndElement()) endElement(xmlEvent);
                else if (xmlEvent.isCharacters()) characters(xmlEvent);
            }
            System.out.println("==================================================================================");
            System.out.println();
        } catch (XMLStreamException e) {
            System.err.println("Error with XML stream: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("Error with file reading " + e.getMessage());
        }
    }

    private static void characters(XMLEvent event) {
        Characters characters = event.asCharacters();
        value.append(characters.getData().trim());
    }

    private static void startElement(XMLEvent event) {
        StartElement startElement = event.asStartElement();
        System.out.printf("%s<%s", tab, startElement.getName().getLocalPart());
        @SuppressWarnings("unchecked")
        Iterator<Attribute> iterator = startElement.getAttributes();
        while (iterator.hasNext()){
            Attribute attribute = iterator.next();
            System.out.printf(" %s=\"%s\"", attribute.getName().getLocalPart(), attribute.getValue());
        }
        System.out.println(">");
        tab = tab.concat("\t");
    }

    private static void endElement(XMLEvent event) {
        EndElement endElement = event.asEndElement();
        if (value.length() > 0)
            System.out.printf("%s%s%n", tab, value);
        tab = tab.substring(1);
        System.out.printf("%s</%s>%n", tab, endElement.getName().getLocalPart());
        value.setLength(0);
    }




}
