package by.it.naumenko.jd02_09.TaskC;

import by.it.naumenko.jd02_09.beens.Cakes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

public class ConverterXmlToJson extends Converter {
    public ConverterXmlToJson(Object object) {
        super(object);
    }

    @Override
    public String getText() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.serializeNulls().setPrettyPrinting().create();
        String json = gson.toJson(bean);
        text = json;
        return json;


    }

    @Override
    void load(String string) {
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(Cakes.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Reader reader = new StringReader(string);
            bean = unmarshaller.unmarshal(reader);
            System.out.println("XML прочитан");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }



}
