package rational;

public class Rational {
	private int numerator, denominator;
	
	public Rational(int num, int den){
		numerator = num;
		denominator = den;
		
		if(denominator == 0)
			denominator = 1;
		
		reduce();
		
		if(denominator < 0){
			denominator = -denominator;
			numerator = -numerator;
		}
	}
	
	public int getNumerator(){
		return numerator;
	}
	
	public int getDenominator(){
		return denominator;
	}
	
	public Rational getReciprocal(){
		return new Rational(denominator, numerator);
	}
	
	public Rational add(Rational other){
		return new Rational(this.getNumerator() * other.getDenominator() + other.getNumerator() * this.getDenominator(), this.getDenominator() * other.getDenominator());
	}
	
	public Rational subtract(Rational other){
		return new Rational(this.getNumerator() * other.getDenominator() - other.getNumerator() * this.getDenominator(), this.getDenominator() * other.getDenominator());
	}
	
	public Rational multiply(Rational other){
		return new Rational(this.getNumerator() * other.getNumerator(), this.getDenominator() * other.getDenominator());
	}
	
	public Rational divide(Rational other){
		return this.multiply(other.getReciprocal());
	}
	
	private void reduce(){
		int GCF = GCF(numerator, denominator);
		denominator /= GCF;
		numerator /= GCF;
	}
	
	private int GCF(int a, int b) {
	   if (b==0)
		   return a;
	   return GCF(b,a%b);
	}

	public boolean equals(Object other){
		Rational rat = (Rational)other;
		return getNumerator() == rat.getNumerator() && getDenominator() == rat.getDenominator();
	}
	
	public int compareTo(Object other){
		Rational oth = (Rational)other;
		Rational result = subtract(oth);
		
		return (result.getNumerator() / result.getDenominator());
	}
	
	public String toString()
	{
		return getNumerator() + "/" + getDenominator();
	}
}
