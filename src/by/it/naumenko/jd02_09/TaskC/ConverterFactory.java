package by.it.naumenko.jd02_09.TaskC;

public class ConverterFactory<T> {

    T bean;

    public ConverterFactory(T bean) {
        this.bean = bean;
    }

    Converter getConverter(Direction direction){

        Converter converter = null;
        if (direction==Direction.JSON_TO_XML)
            converter=new ConverterJsonToXml(bean);
        if (direction==Direction.XML_TO_JSON)
            converter=new ConverterXmlToJson(bean);

        return converter;

    }
}
