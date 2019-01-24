package by.it.nickgrudnitsky.jd02_09.taskC;

import by.it.nickgrudnitsky.jd02_09.beans.Twitch;

class ConverterFactory<T> {
    T bean;
    public ConverterFactory(T object) {
        bean = object;
    }

    Converter getConverter(Direction direction) {
        Converter converter = null;
        switch (direction) {
            case JSON_TO_XML: {
                converter = new ConverterJsonToXml(bean);
                break;
            }
            case XML_TO_JSON: {
                converter = new ConverterXmlToJson(bean);
                break;
            }
        }

        return converter;
    }
}
