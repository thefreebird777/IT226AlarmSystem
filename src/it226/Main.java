package it226;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
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
import java.util.ArrayList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Daniel
 */
public class Main {
    static int count = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        DomParser domParser = new DomParser();
        domParser.write("4", "7", "9", "11", "Test");
        domParser.write("5", "11", "23", "1444", "Test2");
        AlarmHome main = new AlarmHome();
        main.setVisible(true);
        UserHandler userhandler = new UserHandler();
        userhandler.read();
    }

    static class UserHandler extends DefaultHandler {
        AlarmBase alarmBase;
        Node nNode;
        String month;
        String day;
        String hour;
        String minutes;
        String message;

        public void read() {
            try{
                if (new File("Instance.xml").isFile()) {
                    File inputFile = new File("Instance.xml");
                    DocumentBuilderFactory dbFactory
                            = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                    Document doc = dBuilder.parse(inputFile);
                    doc.getDocumentElement().normalize();

                    NodeList nList = doc.getElementsByTagName("alarm" + Integer.toString(count - 1));

                    for (int temp = 0; temp < nList.getLength(); temp++) {
                        nNode = nList.item(temp);
                        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element eElement = (Element) nNode;
                            month = eElement.getElementsByTagName("month").item(0).getTextContent();
                            day = eElement.getElementsByTagName("day").item(0).getTextContent();
                            hour = eElement.getElementsByTagName("hour").item(0).getTextContent();
                            minutes = eElement.getElementsByTagName("minutes").item(0).getTextContent();
                            message  = eElement.getElementsByTagName("message").item(0).getTextContent();
                        }
                    }
                    alarmBase = new AlarmBase(nNode, Integer.parseInt(hour), Integer.parseInt(minutes), message, Integer.parseInt(day), Integer.parseInt(month));
                }
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class DomParser {
        public void write(String writeMonth, String writeDay, String writeHour, String writeMinutes, String writeMessage) {

            ArrayList<String> monthAL = new ArrayList<String>();
            ArrayList<String> dayAL = new ArrayList<String>();
            ArrayList<String> hourAL = new ArrayList<String>();
            ArrayList<String> minutesAL = new ArrayList<String>();
            ArrayList<String> messageAL = new ArrayList<String>();

            monthAL.add(writeMonth);
            dayAL.add(writeDay);
            hourAL.add(writeHour);
            minutesAL.add(writeMinutes);
            messageAL.add(writeMessage);

            try {
                if (new File("Instance.xml").isFile()) {
                    File inputFile = new File("Instance.xml");
                    DocumentBuilderFactory dbFactory
                            = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                    Document doc = dBuilder.parse(inputFile);
                    doc.getDocumentElement().normalize();

                    NodeList nList = doc.getElementsByTagName("alarm" + Integer.toString(count - 1));

                    for (int temp = 0; temp < nList.getLength(); temp++) {
                        Node nNode = nList.item(temp);
                        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element eElement = (Element) nNode;
                            monthAL.add(eElement.getElementsByTagName("month").item(0).getTextContent());
                            dayAL.add(eElement.getElementsByTagName("day").item(0).getTextContent());
                            hourAL.add(eElement.getElementsByTagName("hour").item(0).getTextContent());
                            minutesAL.add(eElement.getElementsByTagName("minutes").item(0).getTextContent());
                            messageAL.add(eElement.getElementsByTagName("message").item(0).getTextContent());
                        }
                    }

                }

                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                Document doc = docBuilder.newDocument();

                Element rootElement = doc.createElement("alarms");
                doc.appendChild(rootElement);

                while (!hourAL.isEmpty()) {


                    Element alarm = doc.createElement("alarm" + count);
                    rootElement.appendChild(alarm);

                    Element month = doc.createElement("month");
                    month.appendChild(doc.createTextNode(monthAL.get(0)));
                    monthAL.remove(0);
                    alarm.appendChild(month);

                    Element day = doc.createElement("day");
                    day.appendChild(doc.createTextNode(dayAL.get(0)));
                    dayAL.remove(0);
                    alarm.appendChild(day);

                    Element hour = doc.createElement("hour");
                    hour.appendChild(doc.createTextNode(hourAL.get(0)));
                    hourAL.remove(0);
                    alarm.appendChild(hour);

                    Element minutes = doc.createElement("minutes");
                    minutes.appendChild(doc.createTextNode(minutesAL.get(0)));
                    minutesAL.remove(0);
                    alarm.appendChild(minutes);

                    Element message = doc.createElement("message");
                    message.appendChild(doc.createTextNode(messageAL.get(0)));
                    messageAL.remove(0);
                    alarm.appendChild(message);

                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    DOMSource source = new DOMSource(doc);
                    StreamResult result = new StreamResult(new File("Instance.xml"));

                    transformer.transform(source, result);
                    count++;
                }
            } catch (ParserConfigurationException pce) {
                pce.printStackTrace();
            } catch (TransformerException tfe) {
                tfe.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void deletion(Node node){
        node.getParentNode().removeChild(node);
    }
}
