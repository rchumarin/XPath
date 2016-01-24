package example1;

import java.io.IOException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import javax.xml.xpath.*;

public class XPathBooleanExample {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, 
          IOException, XPathExpressionException {

        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        domFactory.setNamespaceAware(true); // never forget this!
        DocumentBuilder builder = domFactory.newDocumentBuilder();
        Document doc = builder.parse("books.xml");

        XPath xpath = XPathFactory.newInstance().newXPath();    
        XPathExpression expr = xpath.compile("count(//book[author='Neal Stephenson']) > 1");
        
        Object result = expr.evaluate(doc, XPathConstants.BOOLEAN);

        if ((Boolean) result) {
        // edit XML node
            System.out.println("Авторов Neal Stephenson больше одного");
        }
        else System.out.println("Авторов Neal Stephenson ноль");
    }
    
}
