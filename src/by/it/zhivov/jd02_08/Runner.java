package by.it.zhivov.jd02_08;

import java.util.Scanner;

public class Runner {
    private final static String root = "src/by/it/zhivov/jd02_07/";
    private static String fileXML_xsd = System.getProperty("user.dir") + "/src/by/it/zhivov/jd02_07/person+xsd.xml";
    private static String pureXML =root+"person.xml";
    private static String fileHTML = root+"person.html";
    private static String fileXSL=root+"person.xsl";
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("1-SAXParseXML\n2-StAXParseXML\n3-XMLtoHTML_XPath\nВвод");
        int input = in.nextInt();
        switch (input) {
            case 1:
                SAXParse.Parse(fileXML_xsd);
                break;
            case 2:
                STAXParser.staxParser(fileXML_xsd);
                break;
            case 3:
                XMLtoHTML_XSL.xmlToHtml(pureXML,fileHTML,fileXSL);
                break;
        }

    }
}
