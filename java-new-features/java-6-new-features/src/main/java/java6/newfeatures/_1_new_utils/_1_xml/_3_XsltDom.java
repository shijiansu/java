package java6.newfeatures._1_new_utils._1_xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class _3_XsltDom {
  static class ContentHandler extends DefaultHandler {
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
      String name = new String(ch, start, length);
      System.out.print(name + "\t");
    }
  }

  public static void main(String[] args) {

    try {
      DocumentBuilderFactory documentfactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = documentfactory.newDocumentBuilder();
      Document document = builder.newDocument();

      Element root = document.createElement("work-contact-info");

      Element loca = document.createElement("Location");
      loca.setTextContent("Shanghai-shuion-333");
      root.appendChild(loca);

      Element postal = document.createElement("Postal");
      postal.setTextContent("200020");
      root.appendChild(postal);

      Element tel = document.createElement("Tel");
      root.appendChild(tel);

      Element fix = document.createElement("fix");
      fix.setTextContent("63262299");
      tel.appendChild(fix);

      Element mobile = document.createElement("mobile");
      mobile.setTextContent("1581344454");
      tel.appendChild(mobile);

      Element appellation = document.createElement("Appellation");
      appellation.setTextContent("Mr. Wang");
      root.appendChild(appellation);

      document.appendChild(root);

      TransformerFactory tFactory = TransformerFactory.newInstance();
      Transformer transformer;
      transformer = tFactory.newTransformer();
      SAXResult result = new SAXResult();

      ContentHandler cHandler = new ContentHandler();
      result.setHandler(cHandler);
      transformer.transform(new DOMSource(document), result);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
