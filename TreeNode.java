public class TreeNode<Person> {
   
	private TreeNode<Person> root;

	private Person data;
	private String key;
	private TreeNode<Person> leftChild;
	private TreeNode<Person> righChild;

	TreeNode(String key, Person data) {
		this.key = key;
		this.data = data;

	}
	
	// getter methods
	//get data of the Tree Node 
	public Person getData()
	{
		return data;
	}
	
	//get key of the Tree Node
	public String getKey()
	{
		return key;
	}
	
	// get the left child of the TreeNode 
	public TreeNode<Person> getLeft() {
		return leftChild;
	}
	// gets the right child of the TreeNode 
	public TreeNode<Person> getRight() {
		return righChild;
	}

	// Gets the root of the TreeNode 
	public TreeNode<Person> getRoot() {
		return root;
	}

	// setter methods
	// Sets key of the TreeNode
	public void  setKey(String newKey)
	{
		key = newKey;
	}
	
	// Sets data of the TreeNode
	public void setData(Person newPerson)
	{
		data = newPerson;
	}

	// Sets the left child of the TreeNode 
	public void setLeft(TreeNode<Person> newLeftChild) {
		leftChild = newLeftChild;
	}
	
	// Sets right child of the TreeNode 
	public void setRight(TreeNode<Person> newRigtChild) {
		righChild = newRigtChild;
	}



}
