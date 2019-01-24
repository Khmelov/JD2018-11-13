package by.it.vchernetski.jd02_09.TaskC;

import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.*;

public class ConverterJsontoXml extends Converter {
    public ConverterJsontoXml(Class cl){
        super(cl);
    }

    @Override
    public String getText() {
        StringWriter string = new StringWriter();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(beanClass);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(obj,string);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return string.toString();
    }

    @Override
    public void load(String str) {
        obj = new GsonBuilder().create().fromJson(str, beanClass);
    }
}
