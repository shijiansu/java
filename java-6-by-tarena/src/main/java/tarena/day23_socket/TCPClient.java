package tarena.day23_socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient {
	public static void main(String[] args) {
		Socket s = null;
		try {
			s = new Socket("10.3.1.38", 10225);
			InputStream is = s.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			System.out.println(br.readLine());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (s != null)
				try {
					s.close();
				} catch (Exception e) {
				}
		}
	}
}
