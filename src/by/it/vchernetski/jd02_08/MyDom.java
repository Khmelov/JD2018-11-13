package by.it.vchernetski.jd02_08;



import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class MyDom {
    public static void main(String[] args) {
        String name =System.getProperty("user.dir") + "/src/by/it/vchernetski/jd02_07/Drivers+xsd.xml";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder=factory.newDocumentBuilder();
            Document document = builder.parse(name);
            Node node = document.getDocumentElement();
            printout("",node);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printout(String pr, Node node) {
        int t = node.getNodeType();
        if(t==Node.ELEMENT_NODE){
            System.out.print(pr+"<"+node.getNodeName());
            NamedNodeMap att = node.getAttributes();
            while(att.getLength()>0){
                Node a = att.item(0);
                att.removeNamedItem(a.getNodeName());
                System.out.print(" "+a.getNodeName()+"=\""+a.getNodeValue()+"\"");
            }
            System.out.println(">");
        }
        String value = node.getNodeValue();
        if(value!=null){
            value=value.trim();
            if(value.matches(".+")) {
                System.out.println(pr + value);
            }
        }
        NodeList nodes = node.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            printout(pr+"\t",nodes.item(i));
        }
        if(t==Node.ELEMENT_NODE){
            System.out.println(pr+"</"+node.getNodeName()+">");
        }

    }
}
