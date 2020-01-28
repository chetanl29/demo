package com.test.entity;

public class Student {
	
	private int stuId;
	
	private String stuName;
	
	private double stuFees;

	public Student() {
		super();
	}

	public Student(int stuId, String stuName, double stuFees) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuFees = stuFees;
	}

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public double getStuFees() {
		return stuFees;
	}

	public void setStuFees(double stuFees) {
		this.stuFees = stuFees;
	}

}
