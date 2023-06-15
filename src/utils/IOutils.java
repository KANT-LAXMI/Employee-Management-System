package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.app.core.Employee;

public interface IOutils {

	public static void storeAllEmployee(Map<String, Employee> emps, String fileName)
			throws FileNotFoundException, IOException {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
			out.writeObject(emps);
		}
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Employee> restoreAllEmployee(String fileName) {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
			return (Map<String, Employee>) in.readObject();
		} catch (Exception e) {
			return new HashMap<>();
		}

	}

}
