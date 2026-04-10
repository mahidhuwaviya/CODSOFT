package com.codsoft.Interface;
import javax.swing.*;

import com.codsoft.daoImpl.StudentDaoImpl;
import com.codsoft.pojo.Student;
import java.util.List;
import java.awt.*;


public class StudentSystemInterface extends JFrame{
	private StudentDaoImpl daoImpl;
	private JTextField nameField,rollField,gradeField;
	private JButton addButton, displayButton, removeButton, displayAllButton,updateButton;
	private JTextArea displayArea;
	
	public StudentSystemInterface() {
		daoImpl= new StudentDaoImpl();
		setTitle("STUDENT MANAGEMENT SYSTEM");
		setSize(400,600);
		setLayout(new FlowLayout());
		
		add(new JLabel("Name:"));
		nameField= new JTextField(20);
		add(nameField);
		
		add(new JLabel("Roll No:"));
        rollField = new JTextField(20);
        add(rollField);
        
		add(new JLabel("Grade:"));
        gradeField = new JTextField(20);
        add(gradeField);
		
        
        addButton = new JButton("Add Student");
        updateButton = new JButton("Update Student");
        removeButton = new JButton("Remove Student");
        displayButton = new JButton("Display Student");
        displayAllButton = new JButton("Display All");
        add(addButton);
        add(updateButton);
        add(removeButton);
        add(displayButton);
        add(displayAllButton);
        
        displayArea= new JTextArea(15,30);
        add(new JScrollPane(displayArea));
        
        
        addButton.addActionListener(e->{
        	if(validateInput()) {
        		int rollno= Integer.parseInt(rollField.getText());
        		String name= nameField.getText();
        		String grade= gradeField.getText();
        		
        		Student newStudent= new Student(rollno,name,grade);
        		
        		Boolean save= daoImpl.addStudent(newStudent);
        		if(save) {
        			displayArea.append("Successfully Added :) " + name + "\n");
        		}else {
        			displayArea.append("Couldn't Add :( " + name + "\n");
        		}	
        	}
        });
        removeButton.addActionListener(e->{
        	if(validateInput()) {
        		int rollno= Integer.parseInt(rollField.getText());
        		String name= nameField.getText();
        		String grade= gradeField.getText();
        		
        		Student newStudent= new Student(rollno,name,grade);
        		
        		Boolean save= daoImpl.removeStudent(newStudent);
        		if(save) {
        			displayArea.append("Deleted Successfully :) " + name + "\n");
        		}else {
        			displayArea.append("Couldn't Delete :( " + name + "\n");
        		}	
        	}
        });
        
        updateButton.addActionListener(e->{
        	if(validateInput()) {
        		int rollno= Integer.parseInt(rollField.getText());
        		String name= nameField.getText();
        		String grade= gradeField.getText();
        		
        		Student newStudent= new Student(rollno,name,grade);
        		
        		Boolean save= daoImpl.updateStudent(newStudent);
        		if(save) {
        			displayArea.append("Updated Successfully :) " + name + "\n");
        		}else {
        			displayArea.append("Couldn't Update :( " + name + "\n");
        		}	
        	}
        });
        displayButton.addActionListener(e->{
        	
        	if( rollField.getText().isEmpty() ) {
    			JOptionPane.showMessageDialog(this, "This field cannot be empty!!");
    			
    		}
    		int rollno= Integer.parseInt(rollField.getText());
    		Student s= daoImpl.getStudent(rollno);
    		if(s!=null) {
    			   displayArea.setText("--- STUDENT RECORDs ---\n");
                   displayArea.append(String.format("%-10s %-20s %-10s\n", "ROLL", "NAME", "GRADE"));
                   displayArea.append("------------------------------------------\n");

                displayArea.append(String.format("%-10d %-20s %-10s\n", 
                        s.getStuRollNo(), s.getStuName(), s.getStuGrade()));
    		}else {
    			displayArea.append("Couldn't get data :( " );
    		}	
    	
    });
        displayAllButton.addActionListener(e -> {
            List<Student> students = daoImpl.getAllStudent();
            
            if (students != null && !students.isEmpty()) {
                // Clear the area first so it doesn't just keep growing
                displayArea.setText("--- STUDENT RECORDS ---\n");
                displayArea.append(String.format("%-10s %-20s %-10s\n", "ROLL", "NAME", "GRADE"));
                displayArea.append("------------------------------------------\n");

                for (Student s : students) {
                    // Adjust these method names to match your POJO (e.g., getStuName() vs getName())
                    displayArea.append(String.format("%-10d %-20s %-10s\n", 
                                       s.getStuRollNo(), s.getStuName(), s.getStuGrade()));
                }
            } else {
                displayArea.setText("No records found in the system.");
            }
        });
	
	}
	
	private boolean validateInput() {
		if(nameField.getText().isEmpty() || gradeField.getText().isEmpty() || rollField.getText().isEmpty() ) {
			JOptionPane.showMessageDialog(this, "This field cannot be empty!!");
			return false;
		}
		return true;
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->{
			StudentSystemInterface fram = new StudentSystemInterface();
			fram.setVisible(true);
		});
    }

}
