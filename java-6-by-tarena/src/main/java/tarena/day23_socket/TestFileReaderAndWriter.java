package tarena.day23_socket;

import java.io.BufferedReader;
import java.io.FileReader;

public class TestFileReaderAndWriter {
	public static void main(String[] args) throws Exception {
		FileReader fr = new FileReader("2.txt");
		BufferedReader br = new BufferedReader(fr);
		String str = null;
		while ((str = br.readLine()) != null) {
			System.out.println(str);
		}
		br.close();
	}
}
