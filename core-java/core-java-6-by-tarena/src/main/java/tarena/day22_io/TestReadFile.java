package tarena.day22_io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class TestReadFile {
	public static void main(String[] args) throws Exception {
		// 以下方式不好，移植性很差
		FileInputStream fis = new FileInputStream(
				"E:\\sd0810\\eclipsework\\sd0810\\src\\day22\\file\\database.properties");
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String str = null;
		while ((str = br.readLine()) != null) {
			System.out.println(str);
		}
		br.close();
		InputStream is = ClassLoader
				.getSystemResourceAsStream("day22/file/database.properties");
		Properties prop = new Properties();
		prop.load(is);
		is.close();
		System.out.println(prop.getProperty("driver"));
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));

	}
}
