package com.app.core;

import java.time.LocalDate;

public class Employee {
	private String id;
	private String firstName;
	private String lastNAme;
	private Department dept;
	private LocalDate date;
	private double salary;
	public Employee(String id, String firstName, String lastNAme, Department dept, LocalDate date, double salary) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastNAme = lastNAme;
		this.dept = dept;
		this.date = date;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastNAme=" + lastNAme + ", dept=" + dept
				+ ", date=" + date + ", salary=" + salary + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastNAme() {
		return lastNAme;
	}
	public void setLastNAme(String lastNAme) {
		this.lastNAme = lastNAme;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	

}
