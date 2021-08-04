
public class BSTPhoneNo {

	TreeNode<Person> rootPhoneNumber;
	public BSTPhoneNo()
	{
		rootPhoneNumber = null;
	}


	// insert method that takes a person object and returns True if added
	// and False if the phone number is already exist.
	public boolean insert(Person data) {


		// Find the parent of the new node Person data	

		TreeNode<Person> parent = null;
		TreeNode<Person> current = rootPhoneNumber;
		while (current != null)
		{
			if (data.getPhoneNumber().compareTo(current.getKey()) < 0 ) {
				parent = current;
				current = current.getLeft();
			} else if (data.getPhoneNumber().compareTo(current.getKey()) > 0) {
				parent = current;
				current = current.getRight();
			} else
				return false; // Duplicate Phone Number won't not insert
		}


		// Create the new node and attach it to the parent node 
		if (rootPhoneNumber == null)
			rootPhoneNumber = new TreeNode<Person>(data.getPhoneNumber(), data); // Create a new root
		else if (data.getPhoneNumber().compareTo(parent.getKey()) < 0)
			parent.setLeft(new TreeNode<Person>(data.getPhoneNumber(), data));
		else
			parent.setRight( new TreeNode<Person>(data.getPhoneNumber(), data));

		return true;

	}

	// delete method that takes a name and phone number and returns True if deleted and False if there is no person with such pair of value exists.
	public boolean delete(Person data) {
		// Find the parent of the new node Person data


		// Find the node and its parent.
		TreeNode<Person> parent = null;
		TreeNode<Person> current = rootPhoneNumber;

		while (current != null && current.getKey().compareTo(data.getPhoneNumber()) != 0 ) {
			parent = current;
			if (data.getPhoneNumber().compareTo(current.getKey()) < 0)
				current = current.getLeft();
			else
				current = current.getRight();
		}
		// Delete the node (if any) and return the removed item.
		if (current == null ) // no such key
			return false;
		else if(!current.getData().equals(data)){ // no such phone number and name 
			return false;
		}
		else {
			deleteNode(current, parent);
			return true;
		}
	}


	//helper method for the delete method above
	private void deleteNode(TreeNode<Person> toDelete, TreeNode<Person> parent) {

		if (toDelete.getLeft() == null || toDelete.getRight() == null) {
			// Cases 1 and 2 x (the node to delete) has one or no children.
			TreeNode<Person> toDeleteChild = null;
			if (toDelete.getLeft() != null)
				toDeleteChild = toDelete.getLeft();
			else
				toDeleteChild = toDelete.getRight();
			// both Cases are included. In case 1 toDeleteChild==null
			if (toDelete == rootPhoneNumber)
				rootPhoneNumber = toDeleteChild;
			else if (toDelete.getKey().compareTo(parent.getKey()) < 0)
				parent.setLeft(toDeleteChild);
			else
				parent.setRight(toDeleteChild);
		}else	{  // case 3 -- x(the node to delete has 2 children) 

			// Get the smallest item in the right subtree.
			TreeNode<Person> replacementParent = toDelete;
			TreeNode<Person> replacement = toDelete.getRight();
			while(replacement.getLeft() != null) {
				replacementParent = replacement;
				replacement = replacement.getLeft();
			}
			// Replace toDelete's key and data
			toDelete.setKey(replacement.getKey());
			toDelete.setData(replacement.getData());

			// Recursively delete the replacement item's old node.
			deleteNode(replacement, replacementParent);
		}

	}
	
	//method that prints the person name and number by their phonenumber as key
	public String search(String key) {
		String searchPersonNameAndNumber = "";
		TreeNode<Person> node = searchTree(rootPhoneNumber, key);
		if(node != null) {
			searchPersonNameAndNumber = node.getData().toString();
		}
		else {
			searchPersonNameAndNumber = "Oops, not able to find a person with the searched phone number";
		}
		return searchPersonNameAndNumber;
	}

	//search method to traverse through the phonenumber node by key(phonenumber)
	private TreeNode<Person> searchTree(TreeNode<Person> root, String key) {
		TreeNode<Person> trav = root;
		while (trav != null) {
			if (key == trav.getKey())
				return trav;
			else if (key.compareTo(trav.getKey())< 0)
				trav = trav.getLeft();
			else
				trav = trav.getRight();

		}
		return null;
	}


	// This method prints InOrder (i.e it will print all persons in the phone book
	// in the ascending order of the key)
	public void inOrder(TreeNode<Person> root) {
		if (root == null) {
			return;
		}
		inOrder(root.getLeft());
		System.out.println(root.getData().toString() + " ");
		inOrder(root.getRight());
	}


}