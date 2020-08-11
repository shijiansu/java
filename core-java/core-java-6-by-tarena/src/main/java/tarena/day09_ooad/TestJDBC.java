package tarena.day09_ooad;

//========SUN=============
interface Driver{
    void connect();//连接数据库
    void executeSQL(String sql);
    //...
}

//======Oracle==========
class OracleDriver implements Driver{
    public void connect(){
		System.out.println("连接到Oracle");
    }
	public void executeSQL(String sql){
		System.out.println("oracle execute "+sql);
	}
}
//=========IBM==========
class DB2Driver implements Driver{
	public void connect(){
		System.out.println("连接到DB2");
    }
	public void executeSQL(String sql){
		System.out.println("db2 execute "+sql);
	}
}

//==========Microsoft==================
class SQLServerDriver implements Driver{
	public void connect(){
		System.out.println("连接到SQLServer");
    }
	public void executeSQL(String sql){
		System.out.println("SQLServer execute "+sql);
	}
}

//================MySql=================
class MySqlDriver implements Driver{
	public void connect(){
		System.out.println("连接到MySql");
    }
	public void executeSQL(String sql){
		System.out.println("MySql execute "+sql);
	}
}

//=============Developer===============
public class TestJDBC{
	public static Driver getDriver(int i){
		if(i==0){
			return new OracleDriver();
		}else if(i==1){
			return new DB2Driver();
		}else if(i==2){
			return new SQLServerDriver();
		}else if(i==3){
			return new MySqlDriver();
		}
		return null;
	}
	public static void main(String[]args){
		Driver d = getDriver(3);
		d.connect();
		d.executeSQL("update test set name = 'haha'");
		d.executeSQL("select * from test");
	}
}