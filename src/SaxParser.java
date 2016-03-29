import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

/**
 * Created by Ian on 3/24/2016.
 */
public class SaxParser {
    static public void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        DomParser domParser = new DomParser();
        //domParser.write();
        File file = new File("Instance.xml");
        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setNamespaceAware(true);
        SAXParser saxParser = spf.newSAXParser();
        UserHandler userhandler = new UserHandler();
        saxParser.parse(file, userhandler);
    }

    static class UserHandler extends DefaultHandler {
        //Class obj = new Class();
        String month;
        String day;
        String hour;
        String minutes;

        boolean bMonth = false;
        boolean bDay = false;
        boolean bHour = false;
        boolean bMinutes = false;
        boolean bMessage = false;

        public void startElement(String uri,
                                 String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("MONTH")) {
                bMonth = true;
            }
            if (qName.equalsIgnoreCase("DAY")) {
                bDay = true;
            }
            if (qName.equalsIgnoreCase("HOUR")) {
                bHour = true;
            }
            if (qName.equalsIgnoreCase("MINUTES")) {
                bMinutes = true;
            }
            if (qName.equalsIgnoreCase("MESSAGE")) {
                bMessage = true;
            }
        }

        public void endElement(String uri,
                               String localName, String qName) throws SAXException {

        }

        public void characters(char ch[], int start, int length) throws SAXException {

            if (bMonth) {
                month = (new String(ch, start, length));
                //obj.setMonth(Integer.parseInt(month));
                bMonth = false;
            }

            if (bDay) {
                day = (new String(ch, start, length));
                //obj.setDay(Integer.parseInt(day));
                bDay = false;
            }

            if (bHour) {
                hour = (new String(ch, start, length));
                //obj.setHour(Integer.parseInt(hour));
                bHour = false;
            }

            if (bMinutes) {
                minutes = (new String(ch, start, length));
                //obj.setMinutes(Integer.parseInt(minutes));
                bMinutes = false;
            }

            if (bMessage) {
                //obj.setMessage(new String(ch, start, length));
                bMessage = false;
            }
        }
    }

    static class DomParser {
        public void write(String writeAlarm, String writeDay, String writeHour, String writeMinutes, String writeMessage) {
            try {

                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

                Document doc = docBuilder.newDocument();
                Element rootElement = doc.createElement("alarm");
                doc.appendChild(rootElement);

                Element month = doc.createElement("month");
                month.appendChild(doc.createTextNode(writeAlarm));
                rootElement.appendChild(month);

               Element day = doc.createElement("day");
                day.appendChild(doc.createTextNode(writeDay));
                rootElement.appendChild(day);

                Element hour = doc.createElement("hour");
                hour.appendChild(doc.createTextNode(writeHour));
                rootElement.appendChild(hour);

                Element minutes = doc.createElement("minutes");
                minutes.appendChild(doc.createTextNode(writeMinutes));
                rootElement.appendChild(minutes);

                Element message = doc.createElement("message");
                message.appendChild(doc.createTextNode(writeMessage));
                rootElement.appendChild(message);

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File("Instance.xml"));

                transformer.transform(source, result);

            } catch (ParserConfigurationException pce) {
                pce.printStackTrace();
            } catch (TransformerException tfe) {
                tfe.printStackTrace();
            }
        }
    }
}