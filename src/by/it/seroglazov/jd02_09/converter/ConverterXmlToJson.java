package by.it.seroglazov.jd02_09.converter;

import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;

public class ConverterXmlToJson extends Converter {
    ConverterXmlToJson(Class beanClass) {
        super(beanClass);
    }

    @Override
    public String getText() {
        return new GsonBuilder().serializeNulls().setPrettyPrinting().create().toJson(bean);
    }

    // Read bean from XML String
    @Override
    public void load(String str) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(beanClass);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            bean = unmarshaller.unmarshal(new ByteArrayInputStream(str.getBytes()));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}




























