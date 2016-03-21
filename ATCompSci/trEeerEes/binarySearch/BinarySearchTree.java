package binarySearch;

import java.util.ArrayList;

@SuppressWarnings("rawtypes")
public class BinarySearchTree {
	private TreeNode root;

	public BinarySearchTree() {
		root = null;
	}

	public void add(Comparable val) {
		root = add(val, root);
	}

	@SuppressWarnings("unchecked")
	private TreeNode add(Comparable val, TreeNode tree) {
		if (tree == null)
			return tree = new TreeNode(val);

		Comparable treeValue = tree.getValue();
		int dirTest = val.compareTo(treeValue);

		if (dirTest <= 0)
			tree.setLeft(add(val, tree.getLeft()));
		else if (dirTest > 0)
			tree.setRight(add(val, tree.getRight()));

		return tree;
	}

	public void inOrder() {
		inOrder(root);
		System.out.println("\n\n");
	}

	private void inOrder(TreeNode tree) {
		if (tree != null) {
			inOrder(tree.getLeft());
			System.out.print(tree.getValue() + " ");
			inOrder(tree.getRight());
		}
	}

	// add preOrder, postOrder, and revOrder

	public void preOrder() {
		preOrder(root);
		System.out.println("\n\n");
	}

	private void preOrder(TreeNode tree) {
		if (tree != null) {
			System.out.print(tree.getValue() + " ");
			preOrder(tree.getLeft());
			preOrder(tree.getRight());
		}
	}

	public void postOrder() {
		postOrder(root);
		System.out.println("\n\n");
	}

	private void postOrder(TreeNode tree) {
		if (tree != null) {
			postOrder(tree.getLeft());
			postOrder(tree.getRight());
			System.out.print(tree.getValue() + " ");
		}
	}

	public void revOrder() {
		revOrder(root);
		System.out.println("\n\n");
	}

	private void revOrder(TreeNode tree) {
		if (tree != null) {
			revOrder(tree.getRight());
			System.out.print(tree.getValue() + " ");
			revOrder(tree.getLeft());
		}
	}

	public int getNumLevels() {
		return getNumLevels(root);
	}

	private int getNumLevels(TreeNode tree) {
		if (tree == null)
			return 0;
		else if (getNumLevels(tree.getLeft()) > getNumLevels(tree.getRight()))
			return 1 + getNumLevels(tree.getLeft());
		else
			return 1 + getNumLevels(tree.getRight());
	}

	// add getNumLeaves, getHeight, getWidth, getNumNodes, and isFull

	public int getNumNodes() {
		return getNumItems(root);
	}

	private int getNumItems(TreeNode tree) {
		if (tree == null)
			return 0;
		return 1 + getNumItems(tree.getLeft()) + getNumItems(tree.getRight());
	}

	public int getNumLeaves() {
		return getNumLeaves(root);
	}

	private int getNumLeaves(TreeNode tree) {
		if (tree != null) {
			if (tree.getLeft() == null && tree.getRight() == null)
				return 1 + getNumLeaves(tree.getLeft())
						+ getNumLeaves(tree.getRight());
			return getNumLeaves(tree.getLeft()) + getNumLeaves(tree.getRight());
		}
		return 0;
	}

	public int getHeight() {
		return getHeight(root);
	}

	private int getHeight(TreeNode tree) {
		if (tree == null)
			return 0;
		else if (getHeight(tree.getLeft()) > getHeight(tree.getRight()))
			return 1 + getHeight(tree.getLeft());
		else
			return 1 + getHeight(tree.getRight());
	}

	public int getWidth() {
		return getNumLevels(root.getLeft()) + getNumLevels(root.getRight()) + 1;
	}

	public boolean isFull() {
		return isFull(root);
	}

	private boolean isFull(TreeNode tree) {
		if (tree != null)
			if ((tree.getLeft() != null && tree.getRight() == null)
					|| (tree.getLeft() == null && tree.getRight() != null))
				return false;
			else
				return isFull(tree.getLeft()) && isFull(tree.getRight());

		return true;
	}

	// search
	public boolean search(Comparable x) {
		return search(x, root);
	}

	private boolean search(Comparable x, TreeNode tree) {
		if (tree != null)
			if ((tree.getLeft() != null && tree.getLeft().getValue().equals(x))
					|| (tree.getRight() != null && tree.getRight().getValue()
					.equals(x)))
				return true;
			else
				return search(x, tree.getLeft()) || search(x, tree.getRight());

		return false;
	}

	// maxNode

	public Comparable maxNode() {
		return maxNode(root, root).getValue();
	}

	@SuppressWarnings("unchecked")
	private TreeNode maxNode(TreeNode tree, TreeNode max) {
		if (tree != null) {
			if (tree.getLeft() != null
					&& tree.getLeft().getValue().compareTo(max.getValue()) > 0)
				max = tree.getLeft();
			if (tree.getRight() != null
					&& tree.getRight().getValue().compareTo(max.getValue()) > 0)
				max = tree.getRight();
			if (maxNode(tree.getLeft(), max).getValue().compareTo(
					maxNode(tree.getRight(), max).getValue()) > 0)
				return maxNode(tree.getLeft(), max);
			return maxNode(tree.getRight(), max);
		}

		return max;
	}

	// minNode
	public Comparable minNode() {
		return minNode(root, root).getValue();
	}

	public TreeNode getSmallest(TreeNode tree){
		return minNode(tree, tree);
	}

	@SuppressWarnings("unchecked")
	private TreeNode minNode(TreeNode tree, TreeNode min) {
		if (tree != null) {
			if (tree.getLeft() != null
					&& tree.getLeft().getValue().compareTo(min.getValue()) < 0)
				min = tree.getLeft();
			if (tree.getRight() != null
					&& tree.getRight().getValue().compareTo(min.getValue()) < 0)
				min = tree.getRight();
			if (minNode(tree.getLeft(), min).getValue().compareTo(
					minNode(tree.getRight(), min).getValue()) < 0)
				return minNode(tree.getLeft(), min);
			return minNode(tree.getRight(), min);
		}

		return min;
	}

	// level order
	public void levelOrder() {
		System.out.println(calculateLevelOrder().replaceAll("\\|", ""));
	}

	private String ret;

	private String calculateLevelOrder() {
		int h = getHeight(root);
		ret = "";
		for (int i = 1; i <= h; i++) {
			levelOrder(root, i);
			ret += "|";
		}
		return ret;
	}

	private void levelOrder(TreeNode tree, int level) {
		if (tree != null) {
			if (level == 1)
				ret += tree.getValue() + " ";
			else if (level > 1) {
				levelOrder(tree.getLeft(), level - 1);
				levelOrder(tree.getRight(), level - 1);
			}
		}
	}

	// display like a tree
	public void treeDisplay() {
		treeDisplay(root);
	}

	private void treeDisplay(TreeNode tree) { //TODO HALP
		if (tree != null) {
			String x = calculateLevelOrder().replaceAll(" ", "-");
			x = x.substring(0, x.length() - 1);
			ArrayList<ArrayList<Integer>> visual = new ArrayList<ArrayList<Integer>>();
			int level = 0;
			visual.add(new ArrayList<Integer>());
			while (x.length() > 1) {
				if (x.charAt(0) == '|') {
					visual.add(new ArrayList<Integer>());
					level++;
					x = x.substring(1);
				}
				visual.get(level).add(Integer.parseInt(x.substring(0, x.indexOf('-'))));
				x = x.substring(x.indexOf('-') + 1);
			}

			for(ArrayList<Integer> i : visual){
				for(Integer w : i)
					System.out.print(w +" ");
				System.out.println();
			}
		}
	}

	// remove

	public void remove(Comparable val){
		root = remove(val, root);
	}

	@SuppressWarnings("unchecked")
	private TreeNode remove(Comparable val, TreeNode tree){
		if(tree != null){
			int dirTest = val.compareTo(tree.getValue());

			if(dirTest < 0)
				tree.setLeft(remove(val, tree.getLeft()));
			else if(dirTest > 0)
				tree.setRight(remove(val, tree.getRight()));
			else
				if(tree.getRight() == null)
					tree = tree.getLeft();
				else{
					TreeNode successor = this.getSmallest(tree.getRight());
					tree.setValue(successor.getValue());
					tree.setRight(remove(successor.getValue(), tree.getRight()));
				}
		}
		return tree;
	}
	public String toString() {
		toString = "";
		toString(root);
		return toString;
	}

	String toString = "";
	private void toString(TreeNode tree) {
		if(tree != null){
			toString(tree.getLeft());
			toString += tree.getValue() + " ";
			toString(tree.getRight());
		}
	}
}