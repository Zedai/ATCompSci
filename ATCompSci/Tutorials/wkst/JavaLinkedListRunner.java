package wkst;

public class JavaLinkedListRunner
{
	public static void main ( String[] args )
	{
	  JavaLinkedList test = new JavaLinkedList(new int[]{4,5,6,7,8,9,10,11,12,13});
	  	test(test);
		System.out.println();
	  	test = new JavaLinkedList(new int[]{24,75,86,37,82,94,111,82,43});
		test(test);
		System.out.println();
		test = new JavaLinkedList(new int[]{0,4,5,2,1,4,6});
		test(test);
		System.out.println();
	}
	
	public static void test(JavaLinkedList list){
		System.out.println(list);
		System.out.println("SUM:: " + list.getSum());
		System.out.println("AVERAGE:: " + list.getAvg());
		System.out.println("SMALLEST:: " + list.getSmallest());
		System.out.println("LARGEST:: " + list.getLargest());
	}
}