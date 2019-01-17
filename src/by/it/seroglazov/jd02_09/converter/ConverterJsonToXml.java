package by.it.seroglazov.jd02_09.converter;

import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class ConverterJsonToXml extends Converter {
    ConverterJsonToXml(Class beanClass) {
        super(beanClass);
    }

    // Receive XML-String from bean
    @Override
    public String getText() {
        try {
            JAXBContext context = JAXBContext.newInstance(beanClass);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(bean, stringWriter);
            return stringWriter.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Read bean from JSON String
    @Override
    public void load(String str) {
        bean = new GsonBuilder().create().fromJson(str, beanClass);
    }


}
