package com.codsoft.daoImpl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.codsoft.dao.StudentDao;
import com.codsoft.pojo.Student;

public class StudentDaoImpl implements StudentDao {
	private final String FILE_NAME = "students.txt";
	@Override
	public Boolean addStudent(Student stu) {
		try (BufferedWriter writer= new BufferedWriter(new FileWriter(FILE_NAME,true))){
			writer.write(stu.toCSV());
			writer.newLine();
			return true;
		} catch (IOException e) {
			System.err.println("Error writing to file: " + e.getMessage());		
			return false;	
		}
		
	}
	@Override
	public List<Student> getAllStudent() {
		
		List<Student> allStu= new ArrayList<>();
		File file= new File(FILE_NAME);
		if(!file.exists()) return null;
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
			String line;
			while((line= reader.readLine())!=null){
				String[] data= line.split(",");
				if(data.length==3) {
					allStu.add(new Student(Integer.parseInt(data[0]), data[1],data[2]));
				}
			}
			return allStu;
		} catch (IOException e) {
			System.err.println("Error reading file: " + e.getMessage());
			return null;
		}
		
	}

	@Override
	public Boolean updateStudent(Student stu) {
		List<Student> students=getAllStudent();
		if (students!=null) {
			for (int i = 0; i < students.size(); i++) {
		        if (students.get(i).getStuRollNo() == stu.getStuRollNo()) {
		        	students.set(i, stu);
		            break;
		        }
		    }
			try (BufferedWriter writer= new BufferedWriter(new FileWriter(FILE_NAME,false))){
				for (Student s: students) {
					writer.write(s.toCSV());
					writer.newLine();
				}
				return true;
			}catch(IOException e) {
				e.printStackTrace();
				System.err.println("Error writing to file: " + e.getMessage());	
				return false;
			}
		}
		return false;		
	}

	@Override
	public Boolean removeStudent(Student stu) {
		List<Student> students=getAllStudent();
		if (students!=null) {
			students.removeIf(s-> s.getStuRollNo()==stu.getStuRollNo());
			try (BufferedWriter writer= new BufferedWriter(new FileWriter(FILE_NAME,false))){
				for (Student s: students) {
					writer.write(s.toCSV());
					writer.newLine();
				}
				return true;
			}catch(IOException e) {
				e.printStackTrace();
				System.err.println("Error writing to file: " + e.getMessage());	
				return false;
			}
		}
		return false;
		
	}

	@Override
	public Student getStudent(int stuRoll) {
		List<Student> students=getAllStudent();
		if (students!=null) {
			try{
				for(Student s: students) {
					if(s.getStuRollNo()==stuRoll) {
						return s;
					}
				}
				
			}catch(Exception e) {
				e.printStackTrace();
				System.err.println("Error writing to file: " + e.getMessage());	
				return null;
			}
		}
		return null;
	}


}
