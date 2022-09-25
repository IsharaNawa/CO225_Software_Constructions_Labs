package com.co225;

public class Student {

	private String surname;//save the surname
	private int attendance;//save the attendance
	private static int totalAttendance=0;//save the total numbers of attendance of all the students of this class
	private static int noOfStudents=0; //saving the number of student objects
	
	//default constructor
	Student(){}
	
	//constructor to instantiate objects using surname
	Student(String surname){
		
		this.surname=surname;
		this.noOfStudents +=1;
	}
	
	//setters of the class
	public void setName(String surname) {
		this.surname=surname;
	}
	
	public void setAttendance(int att) {
		this.attendance=att;
	}
	
	public void addToTotalAtt(int att) {
		this.totalAttendance += att;
	}
	
	
	//getters of the class
	public String getName() {
		return this.surname;
		
	}
	
	public int getAtt() {
		return this.attendance;
	}
	
	public int getTotalAtt() {
		return this.totalAttendance;
	}
	
	public int getNoOfStud() {
		return this.noOfStudents;
	}

	
	//getting the information of the student
	public void getInfo() {
		System.out.println(this.surname+" has an attendance of "+this.attendance+
				" with a precentage of "+((float)this.attendance/45*100)+"%");
	}
	
	
}
