package by.it.vchernetski.jd02_09.TaskC;

public class ConverterFactory {
    public Converter getConverter (Direction direction, Class cl){
        switch (direction){
            case JSON_TO_XML:
                return new ConverterJsontoXml(cl);
            case XML_TO_JSON:
                return new ConverterXmlToJson(cl);
        }
        return null;
    }
}
