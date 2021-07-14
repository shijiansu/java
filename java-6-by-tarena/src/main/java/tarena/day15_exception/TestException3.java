package tarena.day15_exception;

import java.sql.SQLException;

public class TestException3 {
	public static void accessDB() throws SQLException {
		throw new SQLException();
	}

	public static void login(String name, String password) {
		try {
			accessDB();
		} catch (SQLException e) {
			System.out.println("处理异常");
			throw new LoginNameOrPasswordException("用户名或密码错误");
		}
	}

	public static void main(String[] args) {
		login("guodh", "abc123");
	}

}
