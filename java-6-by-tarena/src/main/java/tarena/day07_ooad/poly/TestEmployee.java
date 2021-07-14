package tarena.day07_ooad.poly;

class Employee {
	private String name;
	private int birth;

	public Employee(String name, int birth) {
		this.name = name;
		this.birth = birth;
	}

	public String getName() {
		return name;
	}

	public double getSalary(int month) {
		if (month == birth) {
			return 100;
		}
		return 0;
	}
}

class SalariedEmployee extends Employee {
	private double salary;

	public SalariedEmployee(String name, int birth, double salary) {
		super(name, birth);
		this.salary = salary;
	}

	public double getSalary(int month) {
		return salary + super.getSalary(month);
	}
}

class HourlyEmployee extends Employee {
	private double hours;
	private double salaryOfHour;

	public HourlyEmployee(String name, int birth, double hours,
			double salaryOfHour) {
		super(name, birth);
		this.hours = hours;
		this.salaryOfHour = salaryOfHour;
	}

	public double getSalary(int month) {
		if (hours <= 160) {
			return hours * salaryOfHour + super.getSalary(month);
		} else {
			return salaryOfHour * 160 + (hours - 160) * salaryOfHour * 1.5
					+ super.getSalary(month);
		}
	}
}

class SalesEmployee extends Employee {
	private double sales;
	private double pre;

	public SalesEmployee(String name, int birth, double sales, double pre) {
		super(name, birth);
		this.sales = sales;
		this.pre = pre;
	}

	public double getSalary(int month) {
		return sales * pre + super.getSalary(month);
	}
}

class BasePlusSalesEmployee extends SalesEmployee {
	private double baseSalary;

	public BasePlusSalesEmployee(String name, int birth, double sales,
			double pre, double baseSalary) {
		super(name, birth, sales, pre);
		this.baseSalary = baseSalary;
	}

	public double getSalary(int month) {
		return baseSalary + super.getSalary(month);
	}
}

public class TestEmployee {
	public static void main(String[] args) {
		Employee e1 = new Employee("赵君", 2);
		SalariedEmployee e2 = new SalariedEmployee("陈才秀", 1, 8000);
		HourlyEmployee e3 = new HourlyEmployee("王超", 2, 180, 10);
		SalesEmployee e4 = new SalesEmployee("秋娥", 2, 100000, 0.05);
		BasePlusSalesEmployee e5 = new BasePlusSalesEmployee("郭镫鸿", 2, 1000000,
				0.1, 50000);
		System.out.println("========宇宙集团2月份工资表========");
		System.out.println(e1.getName() + ":" + e1.getSalary(2));
		System.out.println(e2.getName() + ":" + e2.getSalary(2));
		System.out.println(e3.getName() + ":" + e3.getSalary(2));
		System.out.println(e4.getName() + ":" + e4.getSalary(2));
		System.out.println(e5.getName() + ":" + e5.getSalary(2));
	}
}