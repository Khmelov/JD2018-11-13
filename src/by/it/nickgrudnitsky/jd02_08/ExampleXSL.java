package by.it.nickgrudnitsky.jd02_08;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class ExampleXSL {

    public static void main(String[] args) {
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource("src/by/it/nickgrudnitsky/jd02_08/twitch.xsl"));
            transformer.transform(new StreamSource("src/by/it/nickgrudnitsky/jd02_08/twitch.xml"),
                    new StreamResult("src/by/it/nickgrudnitsky/jd02_08/twitch.html"));
            System.out.println("Transform src/by/it/nickgrudnitsky/jd02_08/twitch.xml complete.");

        } catch (TransformerException e) {
            System.out.println("Imposible transforme file src/by/it/nickgrudnitsky/jd02_08/twitch.xml");
        }

    }
}
