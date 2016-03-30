package it226;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
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
    static int start = 0;
    static int count = 0;
    static int i = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParserConfigurationException, IOException, TransformerException, SAXException {
        DomParser domParser = new DomParser();
//                domParser.write("4", "7", "9", "11", "Test");
//        domParser.write("5", "11", "23", "1444", "Test2");
//        domParser.write("6", "19", "14", "738", "Test3");
//        domParser.write("7", "634", "3", "112", "Test4");
        if (new File("Close.xml").isFile()) {
            String num = null;
            try {
                // FileReader reads text files in the default encoding.
                FileReader fileReader =
                        new FileReader("Size.txt");

                // Always wrap FileReader in BufferedReader.
                BufferedReader bufferedReader =
                        new BufferedReader(fileReader);

                num = bufferedReader.readLine();
            } catch (FileNotFoundException ex) {

            }
            start = Integer.parseInt(num);
            domParser.checkClose();
        }
//        AlarmHome main = new AlarmHome();
//        main.setVisible(true);
//        UserHandler userhandler = new UserHandler();
//        userhandler.read();
        domParser.close();
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
            try {
                if (new File("Instance.xml").isFile()) {
                    File inputFile = new File("Instance.xml");
                    DocumentBuilderFactory dbFactory
                            = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                    Document doc = dBuilder.parse(inputFile);
                    doc.getDocumentElement().normalize();

                    NodeList nList = doc.getElementsByTagName("alarm" + Integer.toString(0));

                    for (int temp = 0; temp < nList.getLength(); temp++) {
                        nNode = nList.item(temp);
                        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element eElement = (Element) nNode;
                            month = eElement.getElementsByTagName("month").item(0).getTextContent();
                            day = eElement.getElementsByTagName("day").item(0).getTextContent();
                            hour = eElement.getElementsByTagName("hour").item(0).getTextContent();
                            minutes = eElement.getElementsByTagName("minutes").item(0).getTextContent();
                            message = eElement.getElementsByTagName("message").item(0).getTextContent();
                        }
                    }
                    if (day.equals("") && month.equals("")) {
                        alarmBase = new AlarmBase(nNode, Integer.parseInt(hour), Integer.parseInt(minutes), message);
                        alarmBase.checkAlarm(Integer.parseInt(hour), Integer.parseInt(minutes), message);
                    } else {
                        alarmBase = new AlarmBase(nNode, Integer.parseInt(hour), Integer.parseInt(minutes), message, Integer.parseInt(day), Integer.parseInt(month));
                        alarmBase.checkAlarm(Integer.parseInt(hour), Integer.parseInt(minutes), message, Integer.parseInt(day), Integer.parseInt(month));
                    }

                }
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }
        }
    }

    static class DomParser {
        public void write(String writeMonth, String writeDay, String writeHour, String writeMinutes, String writeMessage) {
            ArrayList<NodeList> elementAL = new ArrayList<>();
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


                    NodeList nList = null;

                    while (i < count) {
                        elementAL.add(doc.getElementsByTagName("alarm" + Integer.toString(i)));
                        i++;
                    }

                    int temp = 0;
                    while (temp < elementAL.size()) {
                        nList = elementAL.get(0);
                        elementAL.remove(0);
                        Node nNode = nList.item(0);
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

        public void checkClose() throws ParserConfigurationException, IOException, SAXException, TransformerException {
            ArrayList<NodeList> elementAL = new ArrayList<>();
            ArrayList<String> monthAL = new ArrayList<String>();
            ArrayList<String> dayAL = new ArrayList<String>();
            ArrayList<String> hourAL = new ArrayList<String>();
            ArrayList<String> minutesAL = new ArrayList<String>();
            ArrayList<String> messageAL = new ArrayList<String>();

            if (new File("Close.xml").isFile()) {
                File inputFile = new File("Close.xml");
                DocumentBuilderFactory dbFactory
                        = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(inputFile);
                doc.getDocumentElement().normalize();


                NodeList nList = null;

                if (int j = 0;  j < start ; j++){
                    elementAL.add(doc.getElementsByTagName("alarm" + Integer.toString(j)));
                    j++;
                }

                int temp = 0;
                while (temp < elementAL.size()) {
                    nList = elementAL.get(0);
                    elementAL.remove(0);
                    Node nNode = nList.item(0);
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

                try {
                    transformer.transform(source, result);
                } catch (TransformerException e) {
                    e.printStackTrace();
                }
                count++;
            }
        }

        public void close() throws ParserConfigurationException, IOException, SAXException, TransformerException {
            ArrayList<NodeList> elementAL = new ArrayList<>();
            ArrayList<String> monthAL = new ArrayList<String>();
            ArrayList<String> dayAL = new ArrayList<String>();
            ArrayList<String> hourAL = new ArrayList<String>();
            ArrayList<String> minutesAL = new ArrayList<String>();
            ArrayList<String> messageAL = new ArrayList<String>();

            if (new File("Instance.xml").isFile()) {
                File inputFile = new File("Instance.xml");
                DocumentBuilderFactory dbFactory
                        = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(inputFile);
                doc.getDocumentElement().normalize();


                NodeList nList = null;

                while (i < count) {
                    elementAL.add(doc.getElementsByTagName("alarm" + Integer.toString(i)));
                    i++;
                }

                int temp = 0;
                while (temp < elementAL.size()) {
                    nList = elementAL.get(0);
                    elementAL.remove(0);
                    Node nNode = nList.item(0);
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
                StreamResult result = new StreamResult(new File("Close.xml"));

                transformer.transform(source, result);
            }

            BufferedWriter writer = null;
            try {
                File size = new File("Size");
                writer = new BufferedWriter(new FileWriter(size));
                writer.write(Integer.toString(count));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    writer.close();
                } catch (Exception e) {
                }
            }

        }
    }

    public void deletion(Node node) {
        node.getParentNode().removeChild(node);
    }
}