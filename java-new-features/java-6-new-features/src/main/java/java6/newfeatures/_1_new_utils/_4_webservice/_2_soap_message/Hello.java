package java6.newfeatures._1_new_utils._4_webservice._2_soap_message;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class Hello {
    @WebMethod
    public String hello(String name) {
        return "Hello, " + name + "\n";
    }

    public static void main(String[] args) {
        // create and publish an endpoint
        Hello hello = new Hello();
        Endpoint endpoint = Endpoint.publish("http://localhost:8080/hello", hello);
    }
}

// 运行该程序后, 访问以下网址可得wsdl文件内容.
// http://localhost:8080/hello?wsdl

// 这个时候可以利用命令行, 生成给客户端使用的文件
// wsimport -p shijian.se06.new_WebService.SOAP_message -keep http://localhost:8080/hello?wsdl

// 客户端
//class HelloApp {
//    public static void main(String args[]) {
//        HelloService service = new HelloService();
//        Hello helloProxy = service.getHelloPort();
//        String hello = helloProxy.hello("developer works");
//        System.out.println(hello);
//    }
//}
