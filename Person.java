public class Person implements Comparable<Person>{
	private String name;
	private String phoneNumber;

	public Person(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	//get name
	public String getName(){
		return name;
	}
	
	//set name
	public void setName(String name){
		this.name = name;
	}	 
	
	//get phone number
	public String getPhoneNumber(){
		return phoneNumber;
	}

	//set name
	public void setPhoneNumber(String phoneNumber){

		this.phoneNumber  =  phoneNumber;
	}	 

	public String toString() {
		return "Name: " + getName() + ", Phone Number: " + getPhoneNumber();
	}

	// It returns true or false whether the two objects of type Person(ID and NUM)
	// are the same or not
	// Worst case running time of this method: O(1)
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Person person = (Person) o;

		if (name != null ? !name.equals(person.name) : person.name != null)
			return false;
		if (phoneNumber != null ? !phoneNumber.equals(person.phoneNumber) : person.phoneNumber != null)
			return false;

		return true;
	}
    
	//compares two person objects by phonenumber
	@Override
	public int compareTo(Person person) { 
		return this.getPhoneNumber().compareTo(person.getPhoneNumber());
	}


}