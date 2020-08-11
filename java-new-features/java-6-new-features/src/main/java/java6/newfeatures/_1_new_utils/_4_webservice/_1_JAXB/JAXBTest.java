package java6.newfeatures._1_new_utils._4_webservice._1_JAXB;

import java.io.FileOutputStream;
import java6.newfeatures._1_new_utils._4_webservice._1_JAXB.generated.ObjectFactory;
import java6.newfeatures._1_new_utils._4_webservice._1_JAXB.generated.Tel;
import java6.newfeatures._1_new_utils._4_webservice._1_JAXB.generated.Workcontactinfo;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class JAXBTest {
  public static void main(String[] args) {
    try {

      JAXBContext jContext = JAXBContext.newInstance("shijian.se06.new_WebService.JAXB.generated");

      ObjectFactory factory = new ObjectFactory();

      Workcontactinfo contactinfo = (Workcontactinfo) (factory.createWorkcontactinfo());

      contactinfo.setAppellation("Mr. Wang");

      contactinfo.setLocation("Shanghai-shuion-333");

      contactinfo.setPostal("200020");

      Tel tel = (Tel) (factory.createTel());
      tel.setFix("123456");
      tel.setMobile("1376666666");

      contactinfo.setTel(tel);
      Marshaller marshaller = jContext.createMarshaller();

      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

      // 这个生成在src的外面
      marshaller.marshal(contactinfo, new FileOutputStream("file/workcontactinfo1.xml"));

      System.out.println("java tree converted into xml & filed");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
