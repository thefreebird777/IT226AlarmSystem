import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

/**
 * Created by Ian on 3/24/2016.
 */
public class SaxParser {
    static public void main(String[] args) throws ParserConfigurationException, SAXException {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setNamespaceAware(true);
        SAXParser saxParser = spf.newSAXParser();
        UserHandler userhandler = new UserHandler();
    }

    static class UserHandler extends DefaultHandler {
        boolean element = false;

        public void startElement(String uri,
                                 String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("MONTH")) {
                element = true;
            }
            if (qName.equalsIgnoreCase("DAY")) {
                element = true;
            }
            if (qName.equalsIgnoreCase("HOUR")) {
                element = true;
            }
            if (qName.equalsIgnoreCase("MINUTES")) {
                element = true;
            }
            if (qName.equalsIgnoreCase("MESSAGE")) {
                element = true;
            }
        }

        public void endElement(String uri,
                               String localName, String qName) throws SAXException {
        }
    }
}
