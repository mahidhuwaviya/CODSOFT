package com.codsoft.pojo;

public class Student {

	private int stuRollNo;
	private String stuName;
	private String stuGrade;
	
	public String toCSV() {
		return stuRollNo + "," + stuName + "," + stuGrade;
	}
	
	public Student(int stuRollNo, String stuName, String stuGrade) {
		super();
		this.stuRollNo = stuRollNo;
		this.stuName = stuName;
		this.stuGrade = stuGrade;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getStuRollNo() {
		return stuRollNo;
	}
	public void setStuRollNo(int stuRollNo) {
		this.stuRollNo = stuRollNo;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuGrade() {
		return stuGrade;
	}
	public void setStuGrade(String stuGrade) {
		this.stuGrade = stuGrade;
	}
	@Override
	public String toString() {
		return "Student [stuRollNo=" + stuRollNo + ", stuName=" + stuName + ", stuGrade=" + stuGrade + "]";
	}
	
}
