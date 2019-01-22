package by.it.vchernetski.jd02_09.TaskC;

import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class ConverterXmlToJson extends Converter {
    public ConverterXmlToJson(Class cl){super(cl);}

    @Override
    public String getText() {
        return new GsonBuilder().serializeNulls().setPrettyPrinting().create().toJson(obj);
    }

    @Override
    public void load(String str) {
        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(beanClass);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            obj=unmarshaller.unmarshal(new StringReader(str));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
