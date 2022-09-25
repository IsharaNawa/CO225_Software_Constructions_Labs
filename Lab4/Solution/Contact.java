//this class specify the class object

public class Contact {
	
	//attributes of the class
	private String firstName;
	private String lastName;
	private String phoneNumber;
	
	//this static variables stores the number of object of the class
	private static int noOfContacts=0;
	
	//default constructor
	Contact(){
		noOfContacts +=1;
	}
	
	//instantiating using a constructor
	Contact(String fname){
		this.firstName=fname;
		noOfContacts+=1;
	}
	
	//setters of the class
	public void setF(String fname) {
		this.firstName=fname;
	}
	
	public void setL(String lname) {
		this.lastName=lname;
	}
	
	public void setPNum(String pnum) {
		this.phoneNumber=pnum;
	}
	
	//getters of the class
	public String getFName() {
		return this.firstName;
	}
	
	public String getLName() {
		return this.lastName;
	}

	public String getPNum() {
		return this.phoneNumber;
	}
	
	public int getNoOfContacts() {
		return this.noOfContacts;
	}
	
	//info as a string
	public void printInfo() {
		System.out.print(this.getFName());
		System.out.print(" "+this.getLName());
		System.out.print(" "+this.getPNum());
		System.out.println();
	}
	
}
