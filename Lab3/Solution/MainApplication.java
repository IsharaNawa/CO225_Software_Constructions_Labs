package com.co225;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class MainApplication {

	
	public static void main(String args[]) {
		
		//instantiating the array to store 61 students
		Student myArray[] = new Student[(61)];
		
		//initializing a counter to loop through the for loop
		int counter;
		
		//initializing the string to store the name of the student
		String line=null;
		
		//trying to read the file 
		try {
			
			//getting a file reader 
			FileReader myFile = new FileReader("co225-classlist.txt");
			//reading the file 
			BufferedReader myBufReader = new BufferedReader(myFile);
			counter=0;
			//assigning the each name to student object in array
			while((line=myBufReader.readLine())!=null){
				
				myArray[counter]= new Student(line);
				counter++;
				
			}
			
			//closing the bufferedreader
			myBufReader.close();
		}
		
		//if the file reading fails execute this block
		catch (IOException ioe) {	     
			   ioe.printStackTrace();
	    } 
		
		//assigning the random numbers as the attendance
		int att;
		for(counter=0;counter<myArray.length;counter++) {
			Random rannum = new Random();
			att = rannum.nextInt(46);
			myArray[counter].setAttendance(att);
			myArray[counter].addToTotalAtt(att);
		}
		
		//printing the details of the students
		System.out.println("\nDetails of the students of the class");
		for(counter=0;counter<myArray.length;counter++) {
			System.out.print(counter+1+".");
			myArray[counter].getInfo();
		}
		
		//printing the names of the students who have less attendance
		int counter2=1;
		System.out.println("\n\nStudents who have less than 80% attendance");
		for(counter=0;counter<myArray.length;counter++) {
			double var=(double)myArray[counter].getAtt()/45*100;
			if(var<80.00) {
				System.out.print(counter2+".");
				myArray[counter].getInfo();
				counter2++;
			}
		}
		
		//printing the average of all the percentages of students
		double averageOfAll=(double)myArray[0].getTotalAtt()/(myArray[0].getNoOfStud()*45)*100;
		
		System.out.println("\n\nAverage attendance percentage of all students = "+
		averageOfAll+"%");
		
		
	}
	
	
}
