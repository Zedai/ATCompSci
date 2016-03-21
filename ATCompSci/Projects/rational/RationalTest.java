package rational;

import java.util.Scanner;

public class RationalTest 
{
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner kbd = new Scanner(System.in);
		int n, n2, d, d2;
		
		System.out.println("Input the numerator of the first rational: ");
		n = clip(Integer.parseInt(kbd.nextLine()));
		System.out.println("Input the denominator of the first rational: ");
		d = clip(Integer.parseInt(kbd.nextLine()));
		
		n2 = (int)(Math.random() * 41 -20);
		d2 = (int)(Math.random() * 41 -20);

		Rational r1 = new Rational(n, d), r2 = new Rational(n2, d2), rSum, rDiff, rProd, rQuot, rRecip;
		System.out.println("First rational number: " + r1);
		System.out.println("Second rational number: " + r2);
		
		if(r1.equals(r2))
			System.out.println("r1 and r2 are equal.");
		else
			System.out.println("r1 and r2 are NOT equal.");
		
		if (r1.compareTo(r2) < 0)
			System.out.println("r1 is less than r2.");
		else if (r1.compareTo(r2) > 0)
			System.out.println("r1 is greater than r2.");
		else
			System.out.println("r1 and r2 are equal.");
		
		rRecip = r1.getReciprocal();
		System.out.println("The reciprocal of r1 is: " + rRecip);
		
		rSum = r1.add(r2);
		rDiff = r1.subtract(r2);
		rProd = r1.multiply(r2);
		rQuot = r1.divide(r2);
		
		System.out.println("r1 + r2: " + rSum);
		System.out.println("r1 - r2: " + rDiff);
		System.out.println("r1 * r2: " + rProd);
		System.out.println("r1 / r2: " + rQuot);
		kbd.close();
	}
	
	public static int clip(Integer c) throws Exception{
		if(Math.abs(c) > 20)
			throw new Exception();
		
		return c;
	}
}
