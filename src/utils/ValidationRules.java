 package utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;

import com.app.core.Department;
import com.app.core.Employee;

import custom_Exceptions.EmployeeHandlingException;

public class ValidationRules {

	public static Department parseAndValidateDepartment(String dept) {
		return Department.valueOf(dept.toUpperCase());
	}

	public static void checkForDup( String id,Map<String, Employee> emps) throws EmployeeHandlingException {
		if (emps.containsKey(id))
			throw new EmployeeHandlingException("duplicate found....");
		System.out.println("no duplicates !");
	}

	public static LocalDate parseAndValidateDate(String date) throws EmployeeHandlingException {
		LocalDate joinDate = LocalDate.parse(date);
		int years = Period.between(joinDate, LocalDate.now()).getYears();
		if (years > 3)
			throw new EmployeeHandlingException("invalid join date");
		return joinDate;
	}
	
	public static Employee validatesAllInputs(String id, String firstName, String lastNAme, String dept, String date, double salary,Map<String, Employee> emps) throws EmployeeHandlingException
	{
		checkForDup(id, emps);
		LocalDate Date = parseAndValidateDate(date);
		Department Dept = parseAndValidateDepartment(dept);
		return new Employee(id, firstName, lastNAme, Dept, Date, salary);
	}
}

