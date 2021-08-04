import java.util.LinkedList;

public class Test {

	public static void main(String[] args) {

		System.out.println("Inserts Person objects(Name & Number) in the Double Tree PhoneBooks:");
		//try-catch implemented for error handling of any exceptions
		try
		{
			DoubleTreePhBook dblTreePhBook = new DoubleTreePhBook();
			// inserts the value in both the BSTName & BST Phone# Trees
			dblTreePhBook.PhbBInsert("Rosy", "2134567890");
			dblTreePhBook.PhbBInsert("Alie", "8606313009");
			dblTreePhBook.PhbBInsert("Isha", "8608302732");
			dblTreePhBook.PhbBInsert("Isha", "9123456789");
			dblTreePhBook.PhbBInsert("Amee", "1111113467");
			dblTreePhBook.PhbBInsert("Jane", "0000000030");
			dblTreePhBook.PhbBInsert("Isha", "4567892341");
			dblTreePhBook.PhbBInsert("Tom", "9123456789");

			// prints the inserted person using inorder traversal in the BST Phone# tree
			System.out.println(
					"Prints the inserted persons using BST Phone Number Tree (using phone# as the key & inorder tree traversal):");
			dblTreePhBook.bstPhoneNo.inOrder(dblTreePhBook.bstPhoneNo.rootPhoneNumber);
			// prints the inserted person using inorder traversal in the BST PhoneName tree
			System.out.println(
					"Prints the inserted person using BST Name Tree (using name as key & inorder tree traversal):");
			dblTreePhBook.bstName.inOrder(dblTreePhBook.bstName.rootName);

			System.out.println("Insert Testing for Izzy & Phonenumber 2134567890:");
			boolean insertTesting = dblTreePhBook.PhbBInsert("Izzy", "2134567890");
			// If the phone# is already there, it will return false since it can't add to
			// Double Tree Book
			System.out.println(
					"Phone number is already there, so it will be unable to add Izzy and the method will reutrn false:: "
							+ insertTesting);

			System.out.println("===================================================================================");
			// Tests if delete method, it will return true if name and phone no found else
			// return false otherwise)
			System.out.println("Delete Testing for Jane with Phone# 0000000030 & Amee with Phone# 1111113467");
			// this deletes the person Jane
			dblTreePhBook.PhbBDelete("Jane", "0000000030");
			// this deletes the person Amee
			dblTreePhBook.PhbBDelete("Amee", "1111113467");

			// prints the phonebook without Jane using inorder traversal in the BST Phone# tree
			System.out.println(
					"Prints the phonebook without(\"Jane\", \"0000000030\") (using phone# as the key & inorder tree traversal):");
			dblTreePhBook.bstPhoneNo.inOrder(dblTreePhBook.bstPhoneNo.rootPhoneNumber);
			// prints the inserted person using inorder traversal in the BST PhoneName tree
			System.out.println(
					"Prints the phonebook without(\"Jane\", \"0000000030\") (using name as key  & inorder tree traversal):");
			dblTreePhBook.bstName.inOrder(dblTreePhBook.bstName.rootName);

			System.out.println("Delete Testing for John & Phone# 111111111");
			boolean deleteTesting = dblTreePhBook.PhbBDelete("John", "111111111");
			// Returns false if name is name to be deleted is not found in the phonebook
			System.out.println("The method will return false, since John is not found in the phonebook: " + deleteTesting);

			System.out.println("===================================================================================");
			// Finds list of all phonenumbers assocaited with that same name
			// in this case, it is searcing all instances of name "Isha" & returning a list
			// of all the associated phone#'s
			System.out.println("Search for all phonenumbers with name Isha in the Phonebook ");
			String personName = "Isha";
			LinkedList<Person> phoneNumberList = dblTreePhBook.PhbBNameSeach(personName);
			if (phoneNumberList.size() > 0) {
				// using for each loop
				System.out.print("The phone numbers associated with " + personName + " are: ");
				for (Person p : phoneNumberList) {
					System.out.print(p.getPhoneNumber() + " ");

				}
			} else {
				System.out.print("The " + personName + " doesnot exist in the Double Tree book ");
			}

			System.out.println(" ");
			System.out.println("===================================================================================");
			System.out.println("Search the phone book by phone number and returns the associated name and phone number");
			// searches the phonenumber and finds its assocaited name
			String searchPhoneNumber = "8608302732";
			String personNameAndPhoneNumber = dblTreePhBook.PhbBPhoneSeach(searchPhoneNumber);
			System.out.println("Person name and phone number with searched phone number " + searchPhoneNumber + " -> "
					+ personNameAndPhoneNumber);
			String searchPhoneNumber2 = "8606313009";
			String personNameAndPhoneNumber2 = dblTreePhBook.PhbBPhoneSeach(searchPhoneNumber2);
			System.out.println("Person name and phone number with searched phone number " + searchPhoneNumber2 + " -> "
					+ personNameAndPhoneNumber2);
		}
		catch(Exception ex)
		{
			System.out.print("Plese handle the error: " + ex.getMessage());
		}
	}

}