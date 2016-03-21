package binarySearch;

public class BSTreeRunner
{
   public static void main( String args[] )
   {
 		//add test cases here
 		
 		BinarySearchTree buzzwords = new BinarySearchTree();
 		buzzwords.add(90);
 		buzzwords.add(50);
 		buzzwords.add(40);
 		buzzwords.add(30);
 		buzzwords.add(45);
 		buzzwords.add(65);
 		buzzwords.add(70);
 		buzzwords.add(120);
 		buzzwords.add(100);
 		buzzwords.add(150);
 		System.out.print("In Order:: "); 
 		buzzwords.inOrder();
 		System.out.print("\nPreOrder:: "); 
 		buzzwords.preOrder();
 		System.out.print("\nPost Order:: "); 
 		buzzwords.postOrder();
 		System.out.print("\nRev Order:: "); 
 		buzzwords.revOrder();
 		System.out.print("\nGetNumLevels:: "); 
 		System.out.print(buzzwords.getNumLevels());
 		System.out.print("\nGetNumNodes:: "); 
 		System.out.print(buzzwords.getNumNodes());
 		System.out.print("\nGetNumLeaves:: "); 
 		System.out.print(buzzwords.getNumLeaves());
 		System.out.print("\nGetHeight:: "); 
 		System.out.print(buzzwords.getHeight());
 		System.out.print("\nGetWidth:: "); 
 		System.out.print(buzzwords.getWidth());
 		System.out.print("\nIsFull:: "); 
 		System.out.print(buzzwords.isFull());
 		System.out.print("\nSearch for 70:: "); 
 		System.out.print(buzzwords.search(70));
 		System.out.print("\nSearch for 80:: "); 
 		System.out.print(buzzwords.search(80));
 		System.out.print("\nMaxNode:: "); 
 		System.out.print(buzzwords.maxNode());
 		System.out.print("\nMinNode:: "); 
 		System.out.print(buzzwords.minNode()); 
 		System.out.print("\nLevel Order:: "); 
 		buzzwords.levelOrder();
 		buzzwords.treeDisplay();
   }
}