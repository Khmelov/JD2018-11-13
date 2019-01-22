package by.it.naumenko.jd02_09.TaskC;

import by.it.naumenko.jd02_09.beens.Cakes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class ConverterJsonToXml extends Converter {
    public ConverterJsonToXml(Object object) {
        super(object);
    }

    @Override
    public String getText() {
        String xml=null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(beanClass);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            StringWriter stringWriter=new StringWriter();
            marshaller.marshal(bean, stringWriter);
            xml = stringWriter.toString();
            text=xml;


        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return text;
    }

    @Override
    void load(String string) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.serializeNulls().setPrettyPrinting().create();
        gson.fromJson(string, Cakes.class);
        System.out.println("JOSN прочитан");

    }
}
