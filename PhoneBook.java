import java.util.LinkedList;

//a phonebook interface of type Person 
public interface PhoneBook<Person> {
	boolean PhbBInsert(String name, String phoneNumber);
	boolean PhbBDelete(String name, String phoneNumber);
	LinkedList<Person> PhbBNameSeach(String name);
	String PhbBPhoneSeach(String phoneNumber);

}
