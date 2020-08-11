package tarena.day14_generic;

import java.io.FileInputStream;
import java.util.Properties;

public class TestProperties {
	public static void main(String[] args)throws Exception {
		FileInputStream fis 
		= new FileInputStream("database.properties");
		Properties prop = new Properties();
		prop.load(fis);
		fis.close();
		System.out.println(prop.getProperty("driver"));
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));
	}
}
