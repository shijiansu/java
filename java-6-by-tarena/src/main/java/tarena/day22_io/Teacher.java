package tarena.day22_io;

import java.io.Serializable;

public class Teacher implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5213897210164818327L;
	private String name;

	public Teacher(String name) {
		super();
		this.name = name;
	}

	public void show() {
		System.out.println("Teacher:" + name);
	}
}
