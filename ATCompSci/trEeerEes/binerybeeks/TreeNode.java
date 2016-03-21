package binerybeeks;

public class TreeNode
{
	private PhoneEntry treeNodeValue;
	private TreeNode leftTreeNode;
	private TreeNode rightTreeNode;

	public TreeNode( )
	{
		treeNodeValue = null;
		leftTreeNode = null;
		rightTreeNode = null;
	}

	public TreeNode(PhoneEntry value, TreeNode left, TreeNode right)
	{
		treeNodeValue = value;
		leftTreeNode = left;
		rightTreeNode = right;
	}

	public PhoneEntry getValue()
	{
		return treeNodeValue;
	}

	public TreeNode getLeft()
	{
		return leftTreeNode;
	}

	public TreeNode getRight()
	{
		return rightTreeNode;
	}

	public void setValue(PhoneEntry value)
	{
		treeNodeValue = value;
	}

	public void setLeft(TreeNode left)
	{
		leftTreeNode = (TreeNode)left;
	}

	public void setRight(TreeNode right)
	{
		rightTreeNode = (TreeNode)right;
	}
}