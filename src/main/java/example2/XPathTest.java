package example2;

import java.io.IOException;
import java.util.Iterator;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;

//получения данных из XML c namespace-ами на Java
public class XPathTest {
 
    public static final String TEST_XML2=
        "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
        "<p:itinerary \n" +
        " xmlns:p=\"http://travelcompany.example.org/reservation/travel\" \n" +
        " xmlns:x=\"http:namespace\">\n" +
        "  <p:departure>\n" +
        "    <x:departing >New York</x:departing>\n" +
        "    <arriving>Los Angeles</arriving>\n" +
        "    <p:departureDate>2001-12-14</p:departureDate>\n" +
        "    <p:departureTime>late afternoon</p:departureTime>\n" +
        "    <p:seatPreference>aisle</p:seatPreference>\n" +
        "  </p:departure>\n" +
        "  <p:return>\n" +
        "    <p:departing>Los Angeles</p:departing>\n" +
        "    <arriving>New York</arriving>\n" +
        "    <p:departureDate>2001-12-20</p:departureDate>\n" +
        "    <p:departureTime>mid-morning</p:departureTime>\n" +
        "    <p:seatPreference/>\n" +
        "  </p:return>\n" +
        "</p:itinerary>";
  
    public static void main(String[] args) throws Exception, IOException {
  
        Document doc = XmlUtil.fromXML(TEST_XML2);

        String xpathStr = "//a:itinerary/a:departure/b:departing";
        XPathFactory xpathFact = XPathFactory.newInstance();
        XPath xpath = xpathFact.newXPath();
        xpath.setNamespaceContext(new XmlPathNamespaceContext());
        String result = xpath.evaluate(xpathStr, doc);
        System.out.println("result:" + result);
    }
}