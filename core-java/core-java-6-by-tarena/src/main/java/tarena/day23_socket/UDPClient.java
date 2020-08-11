package tarena.day23_socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
	public static void main(String[] args) throws Exception {
		// 信纸
		byte[] bs = "这是我要发的一封信中的内容".getBytes();
		// 把信纸放入信封,并写上地址和邮编
		DatagramPacket dp = new DatagramPacket(bs, bs.length,
				InetAddress.getByName("10.3.1.38"), 10222);
		// 创建邮筒
		DatagramSocket ds = new DatagramSocket();
		// 发信
		ds.send(dp);

		// ==========收信=============
		byte[] letter = new byte[1024];
		DatagramPacket dp1 = new DatagramPacket(letter, 1024);
		ds.receive(dp1);
		String str = new String(letter, 0, dp1.getLength());
		System.out.println(str);
		ds.close();
	}
}
