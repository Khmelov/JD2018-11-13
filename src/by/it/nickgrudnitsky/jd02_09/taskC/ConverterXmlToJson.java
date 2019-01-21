package by.it.nickgrudnitsky.jd02_09.taskC;

import by.it.nickgrudnitsky.jd02_09.beans.Twitch;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

public class ConverterXmlToJson<T> extends Converter{

    ConverterXmlToJson(Object object) {
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
    public void load(String string) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Twitch.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Reader reader = new StringReader(string);
        System.out.println("XML прочитан");
        bean = (T) unmarshaller.unmarshal(reader);
    }
}
