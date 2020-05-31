package main.java;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;

public class SerializeUtil {

	public static String getSerializedString(Employee emp) {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(baos);

			oos.writeObject(emp);
			oos.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

		return Base64.getEncoder().encodeToString(baos.toByteArray());

	}

	public static Employee deSerializeObjectFromString(String s) {

		Object o = null;
		byte[] data = Base64.getDecoder().decode(s);
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new ByteArrayInputStream(data));

			o = ois.readObject();
			ois.close();

		} catch (IOException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		return (Employee) o;
	}

}
