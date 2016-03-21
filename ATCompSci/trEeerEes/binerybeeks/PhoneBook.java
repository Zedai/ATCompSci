package binerybeeks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@SuppressWarnings("rawtypes")
public class PhoneBook {
	TreeNode root;

	public PhoneBook(File f) throws FileNotFoundException {
		Scanner in = new Scanner(f);
		root = new TreeNode(new PhoneEntry(in.next(), in.next()), null, null);
		while (in.hasNextLine())
			add(new PhoneEntry(in.next(), in.next()));
		in.close();
	}

	public void add(PhoneEntry val) {
		root = add(val, root);
	}

	private TreeNode add(PhoneEntry val, TreeNode tree) {
		if (tree == null)
			return tree = new TreeNode(val, null, null);

		Comparable treeValue = tree.getValue();
		int dirTest = val.compareTo(treeValue);

		if (dirTest <= 0)
			tree.setLeft(add(val, tree.getLeft()));
		else if (dirTest > 0)
			tree.setRight(add(val, tree.getRight()));

		return tree;
	}

	public void display() {
		display(root);
	}

	private void display(TreeNode tree) {
		if (tree != null) {
			display(tree.getLeft());
			System.out.println(tree.getValue());
			display(tree.getRight());
		}
	}

	public String lookupNumber(String name) {
		return searchByName(name, root, "-1");
	}

	private String searchByName(String name, TreeNode tree, String number) {
		if (tree != null)
			if ((tree.getLeft() != null && tree.getLeft().getValue().getName()
					.equals(name)))
				return tree.getLeft().getValue().getNumber();
			else if (tree.getRight() != null
					&& tree.getRight().getValue().getName().equals(name))
				return tree.getRight().getValue().getNumber();
			else {
				if (!searchByName(name, tree.getLeft(), number).equals("-1"))
					return searchByName(name, tree.getLeft(), number);
				else if (!searchByName(name, tree.getRight(), number).equals(
						"-1"))
					return searchByName(name, tree.getRight(), number);
			}

		return "-1";
	}

	public String reverseLookup(String number) {
		return searchByNumber("-1", root, number);
	}

	private String searchByNumber(String name, TreeNode tree, String number) {
		if (tree != null)
			if ((tree.getLeft() != null && tree.getLeft().getValue()
					.getNumber().equals(number)))
				return tree.getLeft().getValue().getName();
			else if (tree.getRight() != null
					&& tree.getRight().getValue().getNumber().equals(number))
				return tree.getRight().getValue().getName();
			else {
				if (!searchByNumber(name, tree.getLeft(), number).equals("-1"))
					return searchByNumber(name, tree.getLeft(), number);
				else if (!searchByNumber(name, tree.getRight(), number).equals(
						"-1"))
					return searchByNumber(name, tree.getRight(), number);
			}

		return "-1";
	}

	public void delete(String val) {
		root = remove(val, root);
	}

	private TreeNode remove(String val, TreeNode tree) {
		if (tree != null) {
			int dirTest = val.compareTo(tree.getValue().getName());

			if (dirTest < 0)
				tree.setLeft(remove(val, tree.getLeft()));
			else if (dirTest > 0)
				tree.setRight(remove(val, tree.getRight()));
			else if (tree.getRight() == null)
				tree = tree.getLeft();
			else {
				TreeNode successor = this.getSmallest(tree.getRight());
				tree.setValue(successor.getValue());
				tree.setRight(remove(successor.getValue().getName(), tree.getRight()));
			}
		}
		return tree;
	}

	public TreeNode getSmallest(TreeNode tree) {
		return minNode(tree, tree);
	}

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

}
