package java6.newfeatures._1_new_utils._1_xml;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class _2_StAX {
    public static void main(String[] args) {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        InputStream input = new ByteArrayInputStream(
                ("<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<work-contact-info>" +
                        "<Location>Shanghai-shuion-333</Location>" +
                        "<Postal>200020</Postal>" +
                        "<Tel><fix>63262299</fix><mobile>" +
                        "1581344454</mobile></Tel>" +
                        "<Appellation>Mr. Wang</Appellation>" +
                        "</work-contact-info>").getBytes());
        try {
            XMLEventReader xmlEventReader = inputFactory.createXMLEventReader(input);
            while (xmlEventReader.hasNext()) {
                XMLEvent event = xmlEventReader.nextEvent();

                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    System.out.println(startElement.getName().toString());
                }

                if (event.isCharacters()) {
                    Characters text = event.asCharacters();
                    if (!text.isWhiteSpace()) {
                        System.out.println("\t" + text.getData());
                    }
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

}
