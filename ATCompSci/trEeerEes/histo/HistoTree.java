package histo;

@SuppressWarnings({"rawtypes", "unchecked"})
public class HistoTree
{
	private HistoNode root;

	public HistoTree( )
	{
		root = null;
	}

	public void addData(Comparable data)
	{
		add(data, root);
	}

	private HistoNode add(Comparable data, HistoNode tree)
	{
		if(root == null)
			return root = new HistoNode(data, 1, null, null);
		
		if(tree == null)
			return tree = new HistoNode(data, 1, null, null);

		int dirTest = data.compareTo(tree.getData());

		if(tree.getData().equals(data))
			tree.setDataCount(tree.getDataCount() + 1);
		else if(tree.getLeft() != null && tree.getLeft().getData().equals(data))
			tree.getLeft().setDataCount(tree.getLeft().getDataCount() + 1);
		else if(tree.getRight() != null && tree.getRight().getData().equals(data))
			tree.getRight().setDataCount(tree.getRight().getDataCount() + 1);
		else{
			if (dirTest <= 0)
				tree.setLeft(add(data, tree.getLeft()));
			else if (dirTest > 0)
				tree.setRight(add(data, tree.getRight()));
		}
		return tree;
	}

//	public HistoNode search(Comparable data)
//	{
//		return null;
//	}
//
//	private HistoNode search(Comparable data, HistoNode tree)
//	{
//		return null;
//	}

	public String toString()
	{
		toString = "";
		toString(root);
		return toString;
	}

	String toString = "";
	private void toString(HistoNode tree) {
		if(tree != null){
			toString(tree.getLeft());
			toString += tree.getData() + " - " + tree.getDataCount() + "   ";
			toString(tree.getRight());
		}
	}
}