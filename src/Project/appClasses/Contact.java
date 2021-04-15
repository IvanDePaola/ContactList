package Project.appClasses;

import java.util.ArrayList;

public class Contact implements Comparable<Contact> {
	
	//define attributes
	private String firstName;
	private String lastName;
	
	private int phoneNumber;
	private String eMail;
	
	public Contact(String firstName, String lastName, int i, String string) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = i;
		this.eMail = string;
	}
	public String getfirstName() {
		return this.firstName;
	}

	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getlastName() {
		return this.lastName;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}

	public ArrayList<String> geteMail() {
		return this.eMail;
	}

	public void seteMail(String eMail) {//maybe need to add index input to get back the values
		this.eMail.add(eMail);
	}

	public ArrayList<Integer> getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber.add(phoneNumber);
	}
	

	//toString
	public String toString() {
		return lastName + " " + firstName;
	}

	//implement Comparable - compare contacts by lastName
	//must-have for treeSet
	public int compareTo(Contact o) {
		int valCompare = this.getlastName().compareTo(o.getlastName());
		if(valCompare  == 0)
		return 0;
		else
			if (valCompare < 0)
				return -1;
			else
				return 1;
		
	}
	


}
