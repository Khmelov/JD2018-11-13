package by.it.kovalyova.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamConstants;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class StAXRunner {

    private static String xml = System.getProperty("user.dir") + "/src/by/it/kovalyova/jd02_07/flat.xml";

    private static void writeHtml(ArrayList<String> rows) {
        try {
            FileOutputStream htmlFile = new FileOutputStream(System.getProperty("user.dir") + "/src/by/it/kovalyova/jd02_08/flat.html");
            PrintWriter phtml = new PrintWriter(htmlFile);
            phtml.println("<html>");
            phtml.println("<head>");
            phtml.println("<meta charset=\"utf-8\">");
            phtml.println("</head>");
            phtml.println("<body>");
            phtml.println("<table>");
            phtml.println("<tr>" +
                    "<th>email</th><th>Nick</th>" +
                    "<th>Password :-)</th>" +
                    "<th>Flat</th>" +
                    "<th>Address</th>" +
                    "<th>Rooms</th>" +
                    "<th>Floor</th>" +
                    "<th>Floors</th>" +
                    "<th>Area</th>" +
                    "<th>Price</th>" +
                    "</tr>");

            for (String row : rows) {
                phtml.println(row);
            }
            phtml.println("</table>");
            phtml.println("</body>");
            phtml.println("</html>");
            phtml.close();
        }  catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String tab="";
        StringBuilder content=new StringBuilder();
        ArrayList<String> rows = new ArrayList();

        try {
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            FileInputStream xmlFile=new FileInputStream(xml);
            XMLStreamReader reader = inputFactory.createXMLStreamReader(xmlFile);
            boolean inad = false;
            boolean inel = false;
            StringBuilder row = null;
            String elem;
            while (reader.hasNext()){
                int type = reader.next();
                switch (type){
                    case XMLStreamConstants.START_DOCUMENT:
                        System.out.println("start");
                        break;
                    case XMLStreamConstants.ATTRIBUTE:
                        System.out.println("============================================================");
                        break;
                    case XMLStreamConstants.START_ELEMENT:
                        elem = reader.getName().getLocalPart();
                        if (inad && !elem.equals("flat")) {
                            inel = true;
                            row.append("<td>");
                        }
                        if (elem.equals("ad")) {
                            inad = true;
                            row = new StringBuilder();
                            row.append("<tr>");
                        }
                        StringBuilder att = new StringBuilder();
                        int attributeCount = reader.getAttributeCount();
                        for (int i = 0; i < attributeCount; i++) {
                            String name = reader.getAttributeLocalName(i);
                            String value = reader.getAttributeValue(i);
                            att.append(" ").append(name).append("=\"").append(value).append("\"");
                        }
                        System.out.println(tab + "<" + reader.getLocalName() + att + ">");
                        tab = "\t" + tab;
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        String part = reader.getText();
                        content.append(part.trim());
                        if (inel) {
                            row.append(part.trim());
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        elem = reader.getName().getLocalPart();
                        if (inad && !elem.equals("flat")) {
                            inel = false;
                            row.append("</td>");
                        }
                        if (elem.equals("ad")) {
                            inad = false;
                            row.append("</tr>");
                            rows.add(row.toString());
                        }
                        if (content.length() > 0){
                            System.out.println(tab + content);
                            content.setLength(0);
                        }

                        tab = tab.substring(1);
                        System.out.println(tab + "</" + reader.getLocalName() + ">");
                        break;
                    case XMLStreamConstants.END_DOCUMENT:
                        System.out.println("end");
                        break;
                }

            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }

        /*for (String s: rows) {
            System.out.println(s);
        }*/
        writeHtml(rows);
    }
}
