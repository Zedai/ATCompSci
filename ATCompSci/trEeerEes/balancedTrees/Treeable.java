package balancedTrees;

public interface Treeable
{
	public Object getValue();
	public Treeable getLeft();
	public Treeable getRight();
	public void setValue(@SuppressWarnings("rawtypes") Comparable value);
	public void setLeft(Treeable left);
	public void setRight(Treeable right);
}