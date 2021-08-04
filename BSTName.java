import java.util.LinkedList;


public class BSTName {

	TreeNode<Person> rootName;

	public  BSTName()
	{
		rootName = null;;	

	}
	
	//this method takes name and returns a list of phone numbers (of type linkedlist) with all people with the same name inputted 
	public  LinkedList<Person> searchTree(String key) {

		LinkedList<Person> phoneNumberList = new  LinkedList<Person>();
		TreeNode<Person> trav = rootName;

		while (trav != null) {
			if (key == trav.getKey()) {
				phoneNumberList.add(trav.getData());
				trav = trav.getRight();
			}
			else if (key.compareTo(trav.getKey()) < 0)
				trav = trav.getLeft();
			else
				trav = trav.getRight();

		}
		return phoneNumberList;
	}

	// insert method that takes a person object and returns true if added
	// and False if the phone number is already exist.
	public boolean insert(Person data) {

		// Locate the parent node
		TreeNode<Person> parent = null;
		TreeNode<Person> current = rootName;

		while (current != null)
		{
			if(!current.getData().equals(data)) {
				if(data.getPhoneNumber().compareTo(current.getData().getPhoneNumber()) == 0)
				{
					return false;
				}
				if (data.getName().compareTo(current.getKey()) < 0 ) {
					parent = current;
					current = current.getLeft();
				} else { //To allow duplicate name //if (data.getName().compareTo(current.nameKey) >= 0 ) 
					parent = current;
					current = current.getRight();
				}
			}	
			else
			{
				return false; // Duplicate Person won't  insert
			}
		}
		// Create the new node and attach it to the parent node
		if (rootName == null)
			rootName = new TreeNode<Person>(data.getName(), data); // Create a new root
		else if (data.getName().compareTo(parent.getKey()) < 0)
			parent.setLeft(new TreeNode<Person>(data.getName(), data)); 
		else
			parent.setRight( new TreeNode<Person>(data.getName(), data));


		return true;

	}

	// method that takes a name and phone number and returns True if deleted and False if there is no person with such pair of value exists.
	public boolean delete(Person data) {
		// Find the parent of the new node Person data


		// Find the node and its parent.
		TreeNode<Person> parent = null;
		TreeNode<Person> current = rootName;
		while (current != null && !current.getData().equals(data) ) {
			parent = current;
			if (data.getName().compareTo(current.getKey()) < 0)
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


	// This method takes Delete
	private void deleteNode(TreeNode<Person> toDelete, TreeNode<Person> parent) {

		if (toDelete.getLeft() == null || toDelete.getRight() == null) {
			// Cases 1 and 2 x (the node to delete) has one or no children.
			TreeNode<Person> toDeleteChild = null;
			if (toDelete.getLeft() != null)
				toDeleteChild = toDelete.getLeft();
			else
				toDeleteChild = toDelete.getRight();
			// both Cases are included. In case 1 toDeleteChild==null
			if (toDelete == rootName)
				rootName = toDeleteChild;
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

