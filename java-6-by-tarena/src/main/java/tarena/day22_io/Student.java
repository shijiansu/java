package tarena.day22_io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Student implements Serializable, Cloneable {
	private static final long serialVersionUID = -8539365605138504925L;
	private String name;
	/*
	 * transient修饰符修饰的属性不参于序列化， 也就是不合把这个属性的值写出JVM 一般用来修饰网络连接、数据库连接等属性
	 */
	private/* transient */int age;
	private Teacher teacher;

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void show() {
		System.out.println(name + ":" + age);
	}

	public Object clone() throws CloneNotSupportedException {
		// 浅拷贝
		// return super.clone();
		// 深拷贝
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(this);
			oos.close();
			ByteArrayInputStream bais = new ByteArrayInputStream(
					baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (Exception e) {
			throw new CloneNotSupportedException();
		}
	}
}
