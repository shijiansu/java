package java6.newfeatures._1_new_utils._2_net;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.spi.HttpServerProvider;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

// Java 6 还提供了一个轻量级的纯 Java Http 服务器的实现。这个不错.
public class _2_HttpServer {
    public static void main(String[] args) throws Exception {
        HttpServerProvider httpServerProvider = HttpServerProvider.provider();
        InetSocketAddress addr = new InetSocketAddress(7778);
        HttpServer httpServer = httpServerProvider.createHttpServer(addr, 1);
        httpServer.createContext("/myapp/", new MyHttpHandler());
        httpServer.setExecutor(null);
        httpServer.start();
        System.out.println("started");
    }

    static class MyHttpHandler implements HttpHandler {
        public void handle(HttpExchange httpExchange) throws IOException {
            String response = "Hello world!";
            httpExchange.sendResponseHeaders(200, response.length());
            OutputStream out = httpExchange.getResponseBody();
            out.write(response.getBytes());
            out.close();
        }
    }
    // 然后，在浏览器中访问http://localhost:7778/myapp/
}
