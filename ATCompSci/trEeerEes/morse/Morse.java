package morse;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class Morse {
	public static TreeNode root = new TreeNode(null, new TreeNode("T", new TreeNode("M", new TreeNode("O", new TreeNode("-", new TreeNode("0"), new TreeNode("9")), new TreeNode(".", null, new TreeNode("8"))), new TreeNode("G", new TreeNode("Q"), new TreeNode("Z", null, new TreeNode("7")))), new TreeNode("N", new TreeNode("K", new TreeNode("Y"), new TreeNode("C")), new TreeNode("D", new TreeNode("X"), new TreeNode("B", null, new TreeNode("6"))))), new TreeNode("E", new TreeNode("A", new TreeNode("W", new TreeNode("J", new TreeNode("1"), null), new TreeNode("P")), new TreeNode("R", null, new TreeNode("L"))), new TreeNode("I", new TreeNode("U", new TreeNode("-", new TreeNode("2"), null), new TreeNode("F")), new TreeNode("S", new TreeNode("V", new TreeNode("3"), null), new TreeNode("H", new TreeNode("4"), new TreeNode("5"))))));
	public static TreeMap<String, String> decoder = new TreeMap<String, String>();	
	
	public static String decode(String code){
		String t  = "";
		boolean newWord = false;
		String[] c = code.split(" ");

		for(String x : c){
			TreeNode temp = root;
			for(char a : x.toCharArray()){
				if(a == '_')
					temp = temp.getLeft();
				else if(a == '.')
					temp = temp.getRight();
				else if(a == '/')
					newWord = true;
			}
			t += temp.getValue();
			if(newWord){
				t += " ";
				newWord = false;
			}
		}
		
		return t;
	}
	
	public static void init() throws FileNotFoundException{
		Scanner in = new Scanner(new File("H:\\git\\ATCompSci\\ATCompSci\\trEeerEes\\morse\\binidngs"));
		while(in.hasNextLine())
			decoder.put(in.next(), in.nextLine());
		in.close();
	}
	
	public static String encode(String code){
		String t  = "";

		for(char x : code.toCharArray())
			if(x == ' ')
				t += "/";
			else
				t += decoder.get(x + "");
		return t.trim();
	}

	public static void inOrder() {
		inOrder(root);
		System.out.println("\n\n");
	}

	private static void inOrder(TreeNode tree) {
		if (tree != null) {
			inOrder(tree.getLeft());
			System.out.print(tree.getValue() + " ");
			inOrder(tree.getRight());
		}
	}

	
	public static void main(String[] args) throws FileNotFoundException{
		init();
//		System.out.println(decoder.toString());
		System.out.println("DECODE:: " + decode("__ _.__/ .._. . . _/ ... __ . ._.. ._../ ._ _. _../ __ _.__/ _. ___ ... ./ ._. .._ _. ..."));
		System.out.print("ENCODE:: " + encode("MY FEET SMELL AND MY NOSE RUNS") + "\nIN ORDER:: ");
		inOrder();
	}
}
