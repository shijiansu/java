package tarena.day23_socket;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class WebServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(8888);
        while (true) {
            try {
                Socket s = ss.accept();
                Thread t = new RequestProcessor(s);
                t.start();
            } catch (Exception e) {
                ss.close();
            }
        }
    }

    private static class RequestProcessor extends Thread {
        private Socket s;

        public RequestProcessor(Socket s) {
            this.s = s;
        }

        public void run() {
            try {
                OutputStream os = s.getOutputStream();
                SocketAddress sa = s.getRemoteSocketAddress();
                InetSocketAddress isa = (InetSocketAddress) sa;
                InetAddress ia = isa.getAddress();
                String ip = ia.getHostAddress();
                int port = isa.getPort();
                PrintWriter pw = new PrintWriter(os);
                pw.println("<html><head><title>我的网站</title></head>");
                pw.println("<body><h1>欢迎进入天堂网站</h1>");
                pw.println("<hr color='blue'></hr>");
                pw.println("<h2>你的IP地址：" + ip + ",你的端口号是：" + port);
                pw.flush();
                pw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
