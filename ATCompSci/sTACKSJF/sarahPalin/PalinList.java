package sarahPalin;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.ArrayList;

public class PalinList
{
	private Queue<String> queue = new LinkedList<String>();
	private Stack<String> stack = new Stack<String>();
	private ArrayList<String> backUp = new ArrayList<String>();

	public PalinList()
	{
		setList("");
	}

	public PalinList(String list)
	{
		setList(list);
	}

	public void setList(String list)
	{
		String[] separate = list.split(" ");
		for(String x : separate){
			backUp.add(x);
			queue.add(x);
			stack.push(x);
		}
	}

	public boolean isPalin()
	{
		while(!stack.isEmpty())
			if(!stack.pop().equals(queue.poll()))
				return false;

		return true;
	}

	public String toString(){
		return backUp.toString();
	}
}