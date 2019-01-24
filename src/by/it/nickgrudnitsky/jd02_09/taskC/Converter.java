package by.it.nickgrudnitsky.jd02_09.taskC;

import by.it.nickgrudnitsky.jd02_09.beans.Twitch;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;

abstract class Converter<T> {

    String text;

    Twitch twitch = new Twitch();
    Class beanClass;

    T bean;

    Converter(T object){
        bean = object;
        beanClass = object.getClass();
    }

     void load(File file) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(beanClass);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        FileReader fileReader = new FileReader(file);
        System.out.println("Файл прочитан:");
        bean = (T) unmarshaller.unmarshal(fileReader);
    }

    public void save(File file) throws IOException {
        Writer writer = new FileWriter(file.getPath());
        writer.write(text);
        writer.flush();
        System.out.println("Файл записан");
    }

    public abstract String getText() throws JAXBException;
    public abstract void load(String string) throws JAXBException;

}
