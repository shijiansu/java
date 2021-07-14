package tarena.day22_io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class TestBufferedReaderAndWriter {
	public static void main(String[] args) throws Exception {
		// 1、创建一个字节流
		FileInputStream fis = new FileInputStream("2.txt");
		// 2、桥转换,把字节输入流转换成字符输入流
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		// 3、构造字符输入流
		BufferedReader br = new BufferedReader(isr);
		String str = null;
		while ((str = br.readLine()) != null) {
			System.out.println(str);
		}
		br.close();
		// 准备字节流
		FileOutputStream fos = new FileOutputStream("peom.txt");
		// 桥转换
		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
		// 构造字符流
		BufferedWriter bw = new BufferedWriter(osw);
		bw.write("你是谁?");
		bw.newLine();
		bw.write("我是谁\n");
		bw.write("你是我是谁？\n");
		bw.write("我是我是谁\n");
		bw.flush();
		bw.close();
		PrintWriter pw = new PrintWriter("peom.txt", "UTF-8");
		pw.println("床前明月光");
		pw.println("疑是地上霜");
		pw.println("举头望明月");
		pw.println("低头思故乡");
		pw.flush();
		pw.close();
	}
}
