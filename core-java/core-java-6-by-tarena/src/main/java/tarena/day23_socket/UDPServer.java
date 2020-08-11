package tarena.day23_socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
	public static void main(String[] args) throws Exception {
		// 邮筒
		DatagramSocket ds = new DatagramSocket(10222);
		// 准备一张纸
		byte[] bs = new byte[1024];
		// 准备信封
		DatagramPacket dp = new DatagramPacket(bs, bs.length);
		// 收信
		ds.receive(dp);
		String str = new String(bs, 0, dp.getLength());
		System.out.println(str);

		// ==========以下为回信=============
		byte[] letter = "你的信我已经收到了，谢谢！".getBytes();
		DatagramPacket dp1 = new DatagramPacket(letter, letter.length,
				dp.getAddress(), dp.getPort());
		ds.send(dp1);
		ds.close();
	}
}
