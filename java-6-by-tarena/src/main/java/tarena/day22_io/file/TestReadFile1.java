package tarena.day22_io.file;

import java.io.InputStream;
import java.util.Properties;

public class TestReadFile1 {
	public static void main(String[] args) throws Exception {
		InputStream is = TestReadFile1.class
				.getResourceAsStream("database.properties");
		Properties prop = new Properties();
		prop.load(is);
		is.close();
		System.out.println(prop.getProperty("driver"));
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));
	}
}
