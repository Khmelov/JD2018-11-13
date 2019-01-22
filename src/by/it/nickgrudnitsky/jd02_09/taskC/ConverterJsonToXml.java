package by.it.nickgrudnitsky.jd02_09.taskC;

import by.it.nickgrudnitsky.jd02_09.beans.Twitch;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class ConverterJsonToXml extends Converter {

    ConverterJsonToXml(Object object) {
        super(object);
    }

    @Override
    public String getText() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(beanClass);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(bean, stringWriter);
        String xml = stringWriter.toString();
        text = xml;
        return xml;
    }

    @Override
    public void load(String string) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.serializeNulls().setPrettyPrinting().create();
        bean = gson.fromJson(string, Twitch.class);
        System.out.println("JSON прочитан");
    }
}
