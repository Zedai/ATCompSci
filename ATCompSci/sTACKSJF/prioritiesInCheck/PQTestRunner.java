package prioritiesInCheck;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -  

public class PQTestRunner
{
	public static void main ( String[] args )
	{
		PQTester pq = new PQTester();
		pq.setPQ("one two three four five six seven");
		System.out.println("toString() - " + pq);
		System.out.println("getMin() - " + pq.getMin());
		System.out.println("getNaturalOrder() - " + pq.getNaturalOrder() + "\n\n");
		
		pq.setPQ("1 2 3 4 5 one two three four five");
		System.out.println("toString() - " + pq);
		System.out.println("getMin() - " + pq.getMin());
		System.out.println("getNaturalOrder() - " + pq.getNaturalOrder() + "\n\n");

		pq.setPQ("a p h j e f m c i d k l g n o b");
		System.out.println("toString() - " + pq);
		System.out.println("getMin() - " + pq.getMin());
		System.out.println("getNaturalOrder() - " + pq.getNaturalOrder() + "\n\n");
	}
}