package by.it.seroglazov.jd02_09.converter;

public class ConverterFactory {
    private ConverterFactory() {
    }

    public static ConverterFactory getFactory(){
        return new ConverterFactory();
    }

    public Converter getConverter(Direction direction, Class beanClass) {
        switch (direction) {
            case XML_TO_JSON:
                return new ConverterXmlToJson(beanClass);
            case JSON_TO_XML:
                return new ConverterJsonToXml(beanClass);
            default:
                return null;
        }
    }
}
