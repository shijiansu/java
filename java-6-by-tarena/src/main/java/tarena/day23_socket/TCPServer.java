package tarena.day23_socket;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TCPServer {
	public static void main(String[] args) {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(10225);
			while (true) {
				Socket s = ss.accept();
				Thread t = new ServerThread(s);
				t.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("服务器故障!");
		} finally {
			if (ss != null)
				try {
					ss.close();
				} catch (Exception e) {
				}
		}
	}
}

class ServerThread extends Thread {
	private Socket s;
	private String[] msgs = { "坚持就是胜利", "蓦然回首，那人却在灯火阑珊处", "程序写得好，要饭要到老",
			"轻轻我走了，正如我轻轻的来" };

	public ServerThread(Socket s) {
		this.s = s;
	}

	public void run() {
		try {
			OutputStream os = s.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.println(msgs[new Random().nextInt(msgs.length)]);
			pw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
