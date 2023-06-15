package testerForEmployee;

import static utils.IOutils.restoreAllEmployee;
import static utils.IOutils.storeAllEmployee;
import static utils.ValidationRules.validatesAllInputs;
import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

import com.app.core.Department;
import com.app.core.Employee;

import utils.ValidationRules;

public class Tester {
	// tsabi with sc
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("enter the file name");
			String fileName = sc.next();
			Map<String, Employee> emps = restoreAllEmployee(fileName);
			System.out.println("Employee restore " + emps);
			boolean exit = false;
			while (!exit) {
				try {
					System.out.println("Enter your choice");
					System.out.println("1:Addition of employee");
					System.out.println("2:displaying employee");
					System.out.println("3:enter the department for promotion");
					System.out.println("4:enter the emp id which you want to remove");
					System.out.println("5:department wise sorted");
					System.out.println("0:exit");
					switch (sc.nextInt()) {
					case 1:
						System.out.println(
								"enter the emp details:String id, String firstName, String lastNAme, Department dept, LocalDate date, double salary");
						Employee e = validatesAllInputs(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(),
								sc.nextDouble(), emps);
						emps.put(e.getId(), e);
						System.out.println("Employee added successfully");

						break;
					case 2:
						System.out.println("displaying employee");
						emps.values().forEach(v -> System.out.println(v));
						break;
						//abc-125 blue 10000 2023-06-02 Hero
						//abc-127 yellow 60000 2023-06-06 Bullet
						//abc-123 red 10000 2023-04-05 Honda
					case 3:
						System.out.println("enter the department for promotion");
						Department d = Department.valueOf(sc.next().toUpperCase());
					
						emps.values().stream().filter(s -> s.getDept().equals(d))
								.forEach(s -> s.setSalary(s.getSalary() * 1.1));
						break;
					case 4:
						System.out.println("enter the emp id which you want to remove");
						String i = sc.next();
						emps.values().removeIf(s -> s.getId().equals(i));
						emps.forEach((k, v) -> System.out.println(v));
						break;
					case 5:
						System.out.println("department wise sorted");
						Department m = Department.valueOf(sc.next().toUpperCase());
//						emps.values().stream().filter(s -> s.getDept().equals(m)).sorted()
//								.forEach(k -> System.out.println(k));
						emps.values().stream().sorted((p1,p2)->p1.getDate().compareTo(p2.getDate()));

						break;
					case 0:
						exit = true;
						storeAllEmployee(emps, fileName);
						break;

					}

				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}
			}
		}

	}

}
