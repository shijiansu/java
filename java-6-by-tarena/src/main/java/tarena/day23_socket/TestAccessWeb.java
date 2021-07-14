package tarena.day23_socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class TestAccessWeb {
	public static void main(String[] args) throws Exception {
		Socket s = new Socket("192.168.0.23", 8080);
		String str = "GET / HTTP/1.0\n\n";
		OutputStream os = s.getOutputStream();
		os.write(str.getBytes());
		InputStream is = s.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String result = null;
		while ((result = br.readLine()) != null) {
			System.out.println(result);
		}
		s.close();
	}
}
