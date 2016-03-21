package firstLook;

public abstract class BinaryTree {

	TreeNode root;

	public BinaryTree() {
		root = null;
	}

	public void setRoot(TreeNode theNewNode) {
		root = theNewNode;
	}

	public TreeNode getRoot() {

		return root;
	}

	boolean isEmpty() {
		return (root == null);
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	private TreeNode add(Comparable val, TreeNode tree) {
		if (tree == null)
			tree = new TreeNode(val, null, null);
		else if (val.compareTo(tree.getLeft()) < 0)
			tree.setLeft((add(val, tree.getLeft())));
		else if (val.compareTo(tree.getValue()) > 0)
			tree.setRight(add(val, tree.getRight()));
		return tree;
	}

	@SuppressWarnings("unused")
	private void inOrder(TreeNode tree){
		if(tree != null){
			inOrder(tree.getLeft());
			System.out.print(tree.getValue() + " ");
			inOrder(tree.getRight());
		}
	}
	@SuppressWarnings("rawtypes")
	public abstract void insert(Comparable item);

	@SuppressWarnings("rawtypes")
	public abstract TreeNode find(Comparable key);

	public int size() {

		return sizeHelper(root);
	}

	private int sizeHelper(TreeNode root) {
		if (root == null)
			return 0;
		else
			return sizeHelper(root.getLeft()) + 1 + sizeHelper(root.getRight());
	}

}
