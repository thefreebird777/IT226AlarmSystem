import javax.xml.parsers.*;

import org.xml.sax.*;
import org.xml.sax.helpers.*;

import java.io.File;
import java.io.IOException;

/**
 * Created by Ian on 3/24/2016.
 */
public class SaxParser {
    static public void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        File file = new File("Instance.xml");
        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setNamespaceAware(true);
        SAXParser saxParser = spf.newSAXParser();
        UserHandler userhandler = new UserHandler();
        saxParser.parse(file , userhandler);
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
}
