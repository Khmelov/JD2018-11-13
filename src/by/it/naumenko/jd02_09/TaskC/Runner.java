package by.it.naumenko.jd02_09.TaskC;

import by.it.naumenko.jd02_09.beens.Cakes;

import java.io.File;

public class Runner {
    static String fileName=System.getProperty("user.dir")+"/src/by/it/naumenko/jd02_09/cakes+xsd.xml";
    static String fileJsonFromXml =System.getProperty("user.dir")+"/src/by/it/naumenko/jd02_09/TaskC/cakes.json";
    static String fileXmlFromJson=System.getProperty("user.dir")+"/src/by/it/naumenko/jd02_09/TaskC/cakes.xml";
    public static void main(String[] args) {

        Cakes cakes = new Cakes();
        File fileXml = new File(fileName);
        ConverterFactory converterFactory = new ConverterFactory(cakes);
        Converter converter = converterFactory.getConverter(Direction.XML_TO_JSON);
        converter.load(fileXml);
        String json = converter.getText();

        converter.save(new File(fileJsonFromXml));
        System.out.println(json);


        Converter converterFromJson = converterFactory.getConverter(Direction.JSON_TO_XML);
        converterFromJson.load(json);
        String xml = converter.getText();
        converterFromJson.save(new File(fileXmlFromJson));
        System.out.println(xml);
    }
}
