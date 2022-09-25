//importing necessary libraries
import java.util.ArrayList;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;


public class Main {
	
	public static void main (String args[]) {
		
		//this array list stores the contact list to store the contact objects
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		
		int counter;		//to handle loops
		
		//trying to read files
		try {
			
			//filename
			//note that file should be at the same directory as .java files
			String filename="contacts.csv";
			
			//file reading
			FileReader myContacts = new FileReader(filename);
			
			//buffered reading
			BufferedReader myBr = new BufferedReader(myContacts);
			
			//some variables to assign contacts in the files to the array list
			String line;
			String lineArray[];
			counter=0;
			
			//assigning values to array list
			while((line=myBr.readLine())!=null) {
				
				lineArray = line.split(",");
				//System.out.println(lineArray[2]);
				Contact temp = new Contact();
				contacts.add(temp);
				contacts.get(counter).setF(lineArray[0]);
				contacts.get(counter).setL(lineArray[1]);
				contacts.get(counter).setPNum(lineArray[2]);
				
				counter++;
			}
			
			myBr.close();
			
		}
		//if trying fails execute these lines
		catch(FileNotFoundException e){
			System.out.println("The contact list is not found.Please chceck the filename and path.");
			e.printStackTrace();
			
		}catch(IOException ie) {
			ie.printStackTrace();
		}
		
		
		//Variables for argument handling
		String NameType=args[0].substring(0, 2);
		String Name=args[0].substring(2).toLowerCase();
		
		//handling the First name scenario
		if(NameType.equals("F:")||NameType.equals("f:")) {
			
			for(counter=0;counter<contacts.size();counter++) {
				
				if(contacts.get(counter).getFName().toLowerCase().equals(Name)) {
					
					contacts.get(counter).printInfo();
						
				}
				
			}
		
		//handling the Last name scenario
		}else if(NameType.equals("L:")||NameType.contentEquals("l:")) {
			
			for(counter=0;counter<contacts.size();counter++) {
				
				if(contacts.get(counter).getLName().toLowerCase().equals(Name)) {
					
					contacts.get(counter).printInfo();
						
				}
				
			}
		
		}
		
		
		
	}

}
