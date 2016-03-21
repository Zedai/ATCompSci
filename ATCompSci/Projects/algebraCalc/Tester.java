package algebraCalc;

public class Tester {

	public static void main(String[] args) {
		Term p = new Term(3, 5);
		Term q = new Term(2, 5);
		Term r = new Term(4, 6);

		System.out.println(p.add(q));
		System.out.println(q.multiply(r));

		Polynomial poly = new Polynomial();
		Polynomial poly2 = new Polynomial();
		poly.addTerm(3, 4);
		poly.addTerm(-2, 0);
		poly.addTerm(1, 3);
		poly.addTerm(4, 2);
		
		poly2.addTerm(-4, 2);
		poly2.addTerm(-7, 4);
		poly2.addTerm(2, 5);
		poly2.addTerm(-7, 5);
		poly2.addTerm(3, - 1);
		
		System.out.println("\nPolynomial 1");
		System.out.println(poly);
		
		System.out.println("\nPolynomial 2");
		System.out.println(poly2);
		
		System.out.println("\nAdding");
		System.out.println(poly.add(poly2));
		
		System.out.println("\nMultiplying");
		System.out.println(poly.multiply(poly2));
		
		System.out.println("\nDerivative of Polynomial 1");
		System.out.println(poly.derivative());
		
		System.out.println("\nDerivative of Polynomial 2");
		System.out.println(poly2.derivative());
	}
}