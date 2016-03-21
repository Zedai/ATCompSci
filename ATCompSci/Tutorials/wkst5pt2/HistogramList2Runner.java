package wkst5pt2;

//© A+ Computer Science  -  www.apluscompsci.com
//Name - Saikiran Nakka
//Date -  11/13/15
//Class - AT Comp Sci
//Lab  - Still spooki friday the 13th

public class HistogramList2Runner
{
	public static void main(String[] args)
	{
		HistoList test = new HistoList();
		String testString = "ABCDEFABCDEFFEDCBAAAAABBBBBCCCDAAAAAAAEEFFF";
		for(char c : testString.toCharArray())
		{
			test.add(c);
		}
		System.out.println(test);


		//add more test cases
		test = new HistoList();
		int[] arr = {11, 22, 33, 44, 55, 66, 33, 44, 22, 11, 11, 11, 11, 22, 11, 11, 11};
		for(int c : arr)
		{
			test.add(c);
		}
		System.out.println(test);
		
		
		test = new HistoList();
		Double[] darr = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 3.3, 4.4, 2.2, 1.1, 1.1, 1.1, 1.1, 2.2, 1.1};
		for(Double c : darr)
		{
			test.add(c);
		}
		System.out.println(test);

		
		//demonstrate bad data check
		test = new HistoList();
		test.add("dog");
		test.add(33);
		test.add(3.4);
		System.out.println(test);
	}
}