package tarena.day09_ooad;

class Teacher implements Cloneable{
    private String name;
    private int age;
    private Address addr;
	public Teacher(String name, int age){
		this.name = name;
		this.age = age;
	}
	public void setAddress(Address addr){
		this.addr = addr;
	}
	public Address getAddress(){
		return addr;
	}
	public void show(){
		System.out.println(name+":"
		+age+":"+addr.getCity()+":"
		+addr.getStreet()+":"+addr.getNumber());
	}
	public Object clone()
		throws CloneNotSupportedException{
		//浅拷贝
		//return super.clone();
		//深拷贝
		Object o =  super.clone();
		Teacher t = (Teacher)o;
		Address newAddr = new Address();
		Address oldAddr = t.getAddress();
		newAddr.setCity(oldAddr.getCity());
		newAddr.setStreet(oldAddr.getStreet());
		newAddr.setNumber(oldAddr.getNumber());
		t.setAddress(newAddr);
		return t;
	}
}
class Address{
    private String city;
    private String street;
    private String number;
	public Address(){}
	public Address(String city, String street, String number){
		this.city = city;
		this.street = street;
		this.number = number;
	}
	public String getCity(){
		return city;
	}
	public String getStreet(){
		return street;
	}
	public String getNumber(){
		return number;
	}
	public void setCity(String city){
		this.city = city;
	}
	public void setStreet(String street){
		this.street = street;
	}
	public void setNumber(String number){
		this.number = number;
	}
}

public class TestClone1{
    public static void main(String[]args)throws Exception{
		Teacher t = new Teacher("陈才秀", 19);
		Address addr = new Address("广州", "天河", "533");
		t.setAddress(addr);
		Teacher t1 = (Teacher)t.clone();
		t1.getAddress().setCity("北京");
		t1.getAddress().setStreet("大钟寺");
		t1.getAddress().setNumber("甲18");
		t.show();
		t1.show();
    }
}