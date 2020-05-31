package src.main;

public class Driver {

	public static void main(String[] args) throws CloneNotSupportedException {

		Department dept = new Department(1, "software");
		Employee emp1 = new Employee(25, "vinayak", dept);

		Employee clonedEmp = (Employee) emp1.clone();

		System.out.println(emp1);
		System.out.println(clonedEmp);
		dept.setDeptName("finance");
		dept.setId(2);
		// after changing details of dept object only emp1 object gets modified without
		// affecting clonedEmp object because we have implemented deep copy principle ,
		// observe how clonable interface is implemented in Employee and Department
		// classes.
		// If cloanble interface was not implemented in Department class then both the
		// objects emp1 and clonedEmp would have got modified
		System.out.println(emp1);
		System.out.println(clonedEmp);

	}

}
