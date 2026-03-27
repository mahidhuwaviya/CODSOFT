package com.codsoft;

import java.util.Scanner;


public class StudentGradeCalculator {
	private int subMaths;
	private int subEng; 
	private int subComp; 
	private int subSci; 
	private int subHindi;
	public void StudentGradeCalculator() {	
		Scanner sc= new Scanner(System.in);
		System.out.println("ENTER MARKS OBTAINED IN EACH SUBJECT (out of 100)\n");
		
		do {
			System.out.println("ENTER MARKS OBTAINED IN MATHS SUBJECT (out of 100):");
			subMaths=sc.nextInt();
			if (subMaths>100 || subMaths<0) {
				System.out.println("Invalid input!!, please enter value between 0 and 100");
	
			}
		}while (subMaths>100);
		do {
			System.out.println("ENTER MARKS OBTAINED IN English SUBJECT (out of 100):");
			subEng=sc.nextInt();
			if (subEng>100 || subEng<0) {
				System.out.println("Invalid input!!, please enter value between 0 and 100");
	
			}
		}while (subEng>100);
		do {
			System.out.println("ENTER MARKS OBTAINED IN Computer SUBJECT (out of 100):");
			subComp=sc.nextInt();
			if (subComp>100 || subComp<0) {
				System.out.println("Invalid input!!, please enter value between 0 and 100");
	
			}
		}while (subComp>100);
		do {
			System.out.println("ENTER MARKS OBTAINED IN Science SUBJECT (out of 100):");
			subSci=sc.nextInt();
			if (subSci>100 || subSci<0) {
				System.out.println("Invalid input!!, please enter value between 0 and 100");
	
			}
		}while (subSci>100);
		do {
			System.out.println("ENTER MARKS OBTAINED IN Hindi SUBJECT (out of 100):");
			subHindi=sc.nextInt();
			if (subHindi>100 || subHindi<0) {
				System.out.println("Invalid input!!, please enter value between 0 and 100");
	
			}
		}while (subHindi>100);
		
		int TotolMarksObtained= subComp+subEng+subHindi+subMaths+subSci;	
		double AveragePercentage= (double)TotolMarksObtained/5;
		String grade;
		if(AveragePercentage>=90) {
			grade="A";
		}else if(AveragePercentage>=80) {
			grade="B";
		}else if(AveragePercentage>=70) {
			grade="C";
		}else if(AveragePercentage>=60) {
			grade="D";
		}else {
			grade="F";
		}
		System.out.println("\nTotal Marks Obtained:"+ TotolMarksObtained);
		System.out.println("\nAverage Percentage:"+ AveragePercentage+"%");
		System.out.println("\nGrade Assigned:"+ grade);

		System.out.println(
				"\nGrading System: \n"+
		         "90% and above is A  --Excellent \n"+
		         "80% to 89% is    B  --VeryGood \n"+
		         "70% to 79% is    C  --Good\n"+
		         "60% to 69% is    D  --Satisfactory\n"+
		         "Below  60% is    F  --fail\n"

				);
		
		
	}
	
	public static void main(String[] args) {
		StudentGradeCalculator sgc= new StudentGradeCalculator();
		sgc.StudentGradeCalculator();
	}
}
