package src.main;

public class Department implements Cloneable {

	private int id;
	private String deptName;

	public Department(int id, String deptName) {

		this.id = id;
		this.deptName = deptName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", deptName=" + deptName + "]";
	}

	// If clone method is not overridden in this class then shallow copy will be
	// created of this object while cloning Employee object
	@Override
	protected Object clone() throws CloneNotSupportedException {

		return super.clone();
	}

}
