package by.it.kovalyova.jd02_09;
/*
import by.it.kovalyova.jd02_07.FlatValidator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

    public class TaskA {
        private static String filename = System.getProperty("user.dir") +
                "/src/by/it/kovalyova/jd02_09/flat.xml";

        public static void main(String[] args) {
            try {
                JAXBContext context = JAXBContext.newInstance(flat.class);
                System.out.println("=========================== FROM XML ==============================");
                Unmarshaller unmarshaller = context.createUnmarshaller();
                flat persons = (flat) unmarshaller.unmarshal(new File(filename));
                System.out.println(flat);

                Marshaller marshaller = context.createMarshaller();
                System.out.println("=========================== TO XML ==============================");
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                marshaller.marshal(flat, System.out);

                System.out.println("=========================== TO JSON ==============================");
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.serializeNulls().setPrettyPrinting().create();
                String jsonText = gson.toJson(flat);
                System.out.println(jsonText);

                System.out.println("=========================== FROM JSON ==============================");
               FlatFromJson = gson.fromJson(jsonText, flat.class);
                System.out.println(flatFromJson);
                if (personsFromJson.toString().equals(persons.toString()))
                    System.out.println("Check OK");

            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
    }
}
*/