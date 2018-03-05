import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        builderFactory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        try {
            builder = builderFactory.newDocumentBuilder();
            doc = builder.parse("C:\\Users\\user\\Desktop\\11-603_Baiburov\\2k\\Java\\4_sem\\lesson1_12_02\\XPath\\src\\main\\resources\\books.xml");
            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();
            List<String> price = getPrice(doc, xpath);
            System.out.println("Price: " + price);
            List<String> title = getTitle(doc, xpath);
            System.out.println("Title: " + title);
            List<String> string = getString(doc, xpath);
            System.out.println("String: " + string);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    //task1
    private static List<String> getPrice(Document doc, XPath xpath) {
        List<String> list = new ArrayList<>();
        try {
            XPathExpression xPathExpression = xpath.compile(
                    "//price"
            );
            NodeList nodes = (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nodes.getLength(); i++)
                list.add(nodes.item(i).getTextContent());
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return list;
    }

    //task2
    private static List<String> getTitle(Document doc, XPath xpath) {
        List<String> list = new ArrayList<>();
        try {
            XPathExpression xPathExpression = xpath.compile(
                    "//title[@lang = 'en']"
            );
            NodeList nodes = (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nodes.getLength(); i++)
                list.add(nodes.item(i).getTextContent());
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return list;
    }

    //task3
    private static List<String> getString(Document doc, XPath xpath) {
        List<String> list = new ArrayList<>();
        try {
            XPathExpression xPathExpression = xpath.compile(
                    "//price/text()"
            );
            NodeList nodes = (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nodes.getLength(); i++)
                list.add(nodes.item(i).getTextContent());
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return list;
    }
}
