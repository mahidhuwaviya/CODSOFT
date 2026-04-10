package com.codsoft.dao;

import java.util.List;

import com.codsoft.pojo.Student;

public interface StudentDao {
	public Boolean addStudent(Student stu);
	public Boolean updateStudent(Student stu);
	public Boolean removeStudent(Student stu);
	public Student getStudent(int stuRoll);
	public List<Student> getAllStudent();


}
