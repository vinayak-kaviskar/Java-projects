package src.main;

public class Employee implements Cloneable {

	private int age;
	private String name;
	private Department dept;

	public Employee(int age, String name, Department dept) {
		
		this.age = age;
		this.name = name;
		this.dept = dept;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [age=" + age + ", name=" + name + ", dept=" + dept + "]";
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {

		// First clone the object of this close then also clone the object of department
		// class and set it into cloned employee object and then return cloned employee
		// object

		Employee clonedEmployee = (Employee) super.clone();
		clonedEmployee.setDept((Department) clonedEmployee.getDept().clone());
		return clonedEmployee;
	}

}
