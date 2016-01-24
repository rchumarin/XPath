package example2;

import java.util.Iterator;
import javax.xml.namespace.NamespaceContext;

public class XmlPathNamespaceContext implements NamespaceContext {

    @Override
    public String getNamespaceURI(String prefix) {
        if ("a".equals(prefix)) {
            return "http://travelcompany.example.org/reservation/travel";
        } else if ("b".equals(prefix)) {
            return "http:namespace";
//      Для случая неизвестного namespace — возвращаю просто вопросик. 
//      Такого namespace-а в тестовом документе нет.
        } else return "?";
    }
    
    @Override
    public String getPrefix(String namespaceURI) {
        return null;
    }

    @Override
    public Iterator getPrefixes(String namespaceURI) {
        return null;
    }
    
}
