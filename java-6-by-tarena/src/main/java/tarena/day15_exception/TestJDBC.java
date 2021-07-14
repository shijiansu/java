package tarena.day15_exception;

import java.io.FileInputStream;
import java.util.Properties;

//========SUN=============
interface Driver {
	void connect();// 连接数据库

	void executeSQL(String sql);
	// ...
}

// ======Oracle==========
class OracleDriver implements Driver {
	public void connect() {
		System.out.println("连接到Oracle");
	}

	public void executeSQL(String sql) {
		System.out.println("oracle execute " + sql);
	}
}

// =========IBM==========
class DB2Driver implements Driver {
	public void connect() {
		System.out.println("连接到DB2");
	}

	public void executeSQL(String sql) {
		System.out.println("db2 execute " + sql);
	}
}

// ==========Microsoft==================
class SQLServerDriver implements Driver {
	public void connect() {
		System.out.println("连接到SQLServer");
	}

	public void executeSQL(String sql) {
		System.out.println("SQLServer execute " + sql);
	}
}

// ================MySql=================
class MySqlDriver implements Driver {
	public void connect() {
		System.out.println("连接到MySql");
	}

	public void executeSQL(String sql) {
		System.out.println("MySql execute " + sql);
	}
}

// =============Developer===============
public class TestJDBC {
	public static Driver getDriver() {
		try {
			FileInputStream fis = new FileInputStream("dbconfig.properties");
			Properties prop = new Properties();
			prop.load(fis);
			String driver = prop.getProperty("driver");
			Class<?> c = Class.forName(driver);
			Object o = c.newInstance();
			return (Driver)o;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		Driver d = getDriver();
		d.connect();
		d.executeSQL("update test set name = 'haha'");
		d.executeSQL("select * from test");
	}
}