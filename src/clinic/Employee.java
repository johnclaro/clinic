package clinic;

public class Employee {
	private String name;
	private int uid, salary;
	
	public Employee(String name, int uid, int salary) {
		this.name = name;
		this.uid = uid;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUID() {
		return uid;
	}

	public void setUID(int uid) {
		this.uid = uid;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String toString() {
		return getClass().getName() + "@" + Integer.toHexString(hashCode()) + "[name='" + this.name + "',uid=" + this.uid + ",salary=" + this.salary + "]";
	}
}
