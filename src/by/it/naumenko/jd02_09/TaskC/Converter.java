package by.it.naumenko.jd02_09.TaskC;

import by.it.naumenko.jd02_09.beens.Cakes;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class Converter<T>{


    String text;
    Cakes cakes = new Cakes();
    Class beanClass;
    T bean;


        public Converter(T object) {
            bean=object;
            beanClass=object.getClass();
        }

        void load(File file) {
            try {
                JAXBContext jaxbContext = JAXBContext.newInstance(beanClass);
                Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                FileReader fileReader = new FileReader(file);
                System.out.println("файл прочитан");
                bean= (T) unmarshaller.unmarshal(fileReader);
            } catch (JAXBException | FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public void save(File file) {
            try {
                Writer fileWriter = new FileWriter(file.getPath());
                fileWriter.write(text);
                fileWriter.flush();
                System.out.println("файл записан");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public String getText(){

            return null;
        }
        void load(String string){

        }
}
