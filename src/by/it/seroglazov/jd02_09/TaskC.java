package by.it.seroglazov.jd02_09;

import by.it.seroglazov.jd02_09.converter.*;
import by.it.seroglazov.jd02_09.beans.recipes.Recipes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TaskC {
    public static void main(String[] args) {
        String parentDir = System.getProperty("user.dir") + "/src/by/it/seroglazov/jd02_09/";
        String recXMLFileName = parentDir + "manualXML/recipes+xsd.xml";

        // Читаем и выводим исходный XML файл
        try {
            Files.readAllLines(Paths.get(recXMLFileName)).forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Can't read file " + recXMLFileName);
        }
        System.out.println();

        // XML -> JSON
        Converter converter = ConverterFactory.getFactory().getConverter(Direction.XML_TO_JSON, Recipes.class);
        converter.load(new File(recXMLFileName)); // <- заполнится bean в converter
        String json = converter.getText();
        //System.out.println(json); // <- на экране напечатает JSON

        // JSON -> XML
        Converter converter2 = ConverterFactory.getFactory().getConverter(Direction.JSON_TO_XML, Recipes.class);
        converter2.load(json);  // <- заполнится bean в converter
        converter2.save(new File(parentDir + "resultC.xml"));
        System.out.println(converter2.getText()); // <- на экране напечатает XML

    }
}
