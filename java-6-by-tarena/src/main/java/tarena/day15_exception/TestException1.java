package tarena.day15_exception;

import java.io.IOException;
import java.util.Random;

public class TestException1 {
	public static void login(String name, String password) {
		if (name.equals("guodh") && password.equals("abc123")) {
			System.out.println("登录成功");
		} else {
			throw new LoginNameOrPasswordException("用户名或密码错误",
					new IOException());
		}
	}

	public static void m() throws AException,FException {
		int i = new Random().nextInt(5);
		switch (i) {
		case 0:
			throw new AException();
		case 1:
			throw new BException();
		case 2:
			throw new CException();
		case 3:
			throw new DException();
		case 4:
			throw new FException();
		}
	}

	public static void main(String[] args) {
		try {
			m();
		} catch (CException c) { // c instanceof AException
		} catch (DException c) {
		} catch (BException c) {
		} catch (AException c) {
		} catch (FException c) {
		}
		try {
			m();
		} catch (Exception a) {
		}

		try {
			login("guodh", "abcabc");
		} catch (LoginNameOrPasswordException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

}

// 自己定义异常
class LoginNameOrPasswordException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3217622288938177070L;

	public LoginNameOrPasswordException() {
	}

	public LoginNameOrPasswordException(String message) {
		super(message);
	}

	public LoginNameOrPasswordException(String message, Throwable t) {
		super(message, t);
	}

	public LoginNameOrPasswordException(Throwable t) {
		super(t);
	}
}

class AException extends Exception {
    private static final long serialVersionUID = -4791242438226841447L;
}

class BException extends AException {
	private static final long serialVersionUID = -2317217089401464173L;
}

class CException extends BException {
	private static final long serialVersionUID = 3050681030716659719L;
}

class DException extends BException {
	private static final long serialVersionUID = 7413088488183391581L;
}

class FException extends Exception {
	private static final long serialVersionUID = 5792816981038117669L;
}
