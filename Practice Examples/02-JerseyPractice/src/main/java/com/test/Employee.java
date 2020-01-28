package com.test;

public class Employee {

	private String empName;
	
	private double empSalary;

	public Employee(String empName, double empSalary) {
		super();
		this.empName = empName;
		this.empSalary = empSalary;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	
}
