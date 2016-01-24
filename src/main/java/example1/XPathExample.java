package example1;

//http://www.ibm.com/developerworks/ru/library/x-javaxpathapi/#listing2

import java.io.IOException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import javax.xml.xpath.*;

public class XPathExample {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, 
          IOException, XPathExpressionException {

        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        domFactory.setNamespaceAware(true); // never forget this!
        DocumentBuilder builder = domFactory.newDocumentBuilder();
        Document doc = builder.parse("books.xml");

        XPath xpath = XPathFactory.newInstance().newXPath();          
        XPathExpression expr = xpath.compile("//book[author='Neal Stephenson']/title/text()");

        Object result = expr.evaluate(doc, XPathConstants.NODE);
        System.out.println(result.toString()); 
        
        result = expr.evaluate(doc, XPathConstants.NODESET);
        NodeList nodes = (NodeList) result;
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getNodeValue()); 
        }
        
    }
    
}
