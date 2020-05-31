package main.java;

public class Driver {

	public static void main(String[] args) {

		/*
		 * Static variables cannot be serialized.
		 *  Variables with transient modifier don't get serialized
		 * Deserialization works as long as the serialversionuid is same 
		 * in the java class and the one fetched from serialized object.
		 * If we don't add serialVersionUid then also serialization and deserialization works provided
		 * we are using same platform and jvm versions because then jvm created a serialversionuid on behalf of us.
		 * serialversionuid depends on jvm version and platform type
		 * 
		 */
		
		
		Employee employee = new Employee(27, "vinayak", 45, "male","pune");
		
		System.out.println(employee);
		
		String serializedEmp = SerializeUtil.getSerializedString(employee);
		
		System.out.println(serializedEmp);
		
		Employee deSerializedEmployee = SerializeUtil.deSerializeObjectFromString(serializedEmp);
		
		System.out.println(deSerializedEmployee);
	}

}
