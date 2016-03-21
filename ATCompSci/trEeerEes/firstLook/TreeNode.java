package firstLook;

/**
 * Implementation of a node of a binary tree.
 *
 * Adapted from the College Board's AP Computer Science AB: Implementation
 * Classes and Interfaces.
 */
public class TreeNode {
	private Object value;
	private TreeNode left;
	private TreeNode right;

	/**
	 * Constructs a new TreeNode with object initValue,
	 *
	 * @param initValue
	 *            New element object
	 * @param initLeft
	 *            Reference to the left element
	 * @param initRight
	 *            Reference to the right element
	 */
	public TreeNode(Object initValue, TreeNode initLeft, TreeNode initRight) {
		value = initValue;
		left = initLeft;
		right = initRight;
	}

	/**
	 * Constructs a single leaf TreeNode
	 *
	 * @param initValue
	 *            New element object
	 */
	public TreeNode(Object initValue) {
		this(initValue, null, null);
	}

	/**
	 * Sets the value attribute of the TreeNode object
	 *
	 * @param theNewValue
	 *            value attribute of the TreeNode object
	 */
	public void setValue(Object theNewValue) {
		value = theNewValue;
	}

	/**
	 * Sets the left attribute of the TreeNode object
	 *
	 * @param theNewLeft
	 *            reference to a TreeNode
	 */
	public void setLeft(TreeNode theNewLeft) {
		left = theNewLeft;
	}

	/**
	 * Sets the right attribute of the TreeNode object
	 *
	 * @param theNewRight
	 *            The new right value
	 */
	public void setRight(TreeNode theNewRight) {
		right = theNewRight;
	}

	/**
	 * Gets the value attribute of the TreeNode object
	 *
	 * @return The value value
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * Gets the left attribute of the TreeNode object
	 *
	 * @return The left value
	 */
	public TreeNode getLeft() {
		return left;
	}

	/**
	 * Gets the right attribute of the TreeNode object
	 *
	 * @return The right value
	 */
	public TreeNode getRight() {
		return right;
	}

	public String toString() {
		return value.toString();
	}

	/**
	 * Prints this node and all of its descendants in sorted order.
	 * 
	 * @param indent
	 *            the indentation level
	 */
	public void printNodes(int indent) {
		if (left != null)
			left.printNodes(indent + 1);
		for (int i = 0; i < indent; i++)
			System.out.print("    ");
		System.out.println(value);
		if (right != null)
			right.printNodes(indent + 1);
	}

}
