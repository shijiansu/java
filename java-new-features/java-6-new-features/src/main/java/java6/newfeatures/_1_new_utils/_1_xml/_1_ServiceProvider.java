package java6.newfeatures._1_new_utils._1_xml;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class _1_ServiceProvider {
    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        System.out.println(factory.getClass());

        // Parse the input
        SAXParser saxParser = factory.newSAXParser();
        System.out.println(saxParser.getClass());

        // Output: class org.apache.xerces.jaxp.SAXParserFactoryImpl
        // Output: class org.apache.xerces.jaxp.SAXParserImpl
    }
}
