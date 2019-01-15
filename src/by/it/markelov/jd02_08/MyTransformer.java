package by.it.markelov.jd02_08;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class MyTransformer {
    public static void main(String[] args) {
        File fileTransformer = new File(Path.pathOfThisDirectory(MyTransformer.class) + File.separator + "XMLtoHTML.xml");
        File fileSource = new File(Path.pathOfThisDirectory(MyTransformer.class) + File.separator + "clients.xml");

        StreamSource styleSource = new StreamSource(fileTransformer);
        StreamSource source = new StreamSource(fileSource);


        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
        try {
            transformer = transformerFactory.newTransformer(styleSource);
            transformer.transform(source, new StreamResult(System.out));

        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
