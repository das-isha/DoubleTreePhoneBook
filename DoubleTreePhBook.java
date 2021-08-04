import java.util.LinkedList;

public class DoubleTreePhBook implements PhoneBook<Person> {

	BSTPhoneNo bstPhoneNo;
	BSTName bstName;
	private TreeNode<Person> rootName;     
	private TreeNode<Person> rootPhoneNo;

	public DoubleTreePhBook() {
		this.bstPhoneNo = new BSTPhoneNo();
		this.bstName = new BSTName();
		this.rootName = bstName.rootName;
		this.rootPhoneNo = bstPhoneNo.rootPhoneNumber;
	}

	// this method takes a name and phone# of a person & returns true if sucesfully added in phonebook
	// and false if the phone number is already exists
	@Override
	public boolean PhbBInsert(String name, String phoneNumber) {
		Person p = new Person(name, phoneNumber);
		boolean isInsertedByBSTPhoneNoTree = false;
		boolean isInsertedByBSTName = false;

		// Insert to phone book using BST PhoneNo
		if (bstPhoneNo.insert(p))
			isInsertedByBSTPhoneNoTree = true;
		else
			isInsertedByBSTPhoneNoTree = false;

		// Insert to phone book using BSTName
		if (isInsertedByBSTPhoneNoTree) {
			if (bstName.insert(p)) {
				isInsertedByBSTName = true;
			} else
				isInsertedByBSTName = false;
		}

		return (isInsertedByBSTPhoneNoTree && isInsertedByBSTName);

	}

	// this method takes a name and phone# of a person & returns true if deleted and false if the person doesnt exist
	@Override
	public boolean PhbBDelete(String name, String phoneNumber) {
		Person p = new Person(name, phoneNumber);
		// Deletes from BSTPhoneNo Tree and retun true if deleted otherwise false
		boolean isDeletedByBSTPhoneNoTree = bstPhoneNo.delete(p);
		// Deletes from BSTPhoneName Tree and retun true if deleted otherwise false
		boolean isDeletedByBSTName = bstName.delete(p);
		return (isDeletedByBSTPhoneNoTree && isDeletedByBSTName);
	}
    
	//this method takes name and returns a list of phone numbers (of type linkedlist) with all people with the same name inputted 
	@Override
	public LinkedList<Person> PhbBNameSeach(String name) {
		LinkedList<Person> phoneNumberList = bstName.searchTree(name);
		return phoneNumberList;

	}
	
    //this method takes a phone number and returns the name of the person that is associated with that phone number
	@Override
	public String PhbBPhoneSeach(String phoneNumber) {
		String name = bstPhoneNo.search(phoneNumber);
		return name;
	}

}